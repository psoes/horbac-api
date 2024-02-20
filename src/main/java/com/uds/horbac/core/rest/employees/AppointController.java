package com.uds.horbac.core.rest.employees;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.uds.horbac.core.dao.organizations.OrganizationRepository;
import com.uds.horbac.core.entities.employees.Employee;
import com.uds.horbac.core.entities.employees.Employs;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.permissions.ApprovalType;
import com.uds.horbac.core.entities.requests.AccessRequest;
import com.uds.horbac.core.entities.requests.AppResponse;
import com.uds.horbac.core.entities.users.Approver;
import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.exceptions.ApiException;
import com.uds.horbac.core.service.users.UserService;
import com.uds.horbac.integration.ApprovalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.employees.AppointsDTO;
import com.uds.horbac.core.entities.employees.Appoints;
import com.uds.horbac.core.service.employees.AppointsService;

@RestController
public class AppointController {

    protected @Autowired AppointsService service;
    protected @Autowired ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Autowired
    ApprovalService approvalService;
    @Autowired
    private OrganizationRepository organizationRepository;

    @RequestMapping(value = "/appoints", method = GET)
    public List<AppointsDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
        return service.getAll().stream()
                .map(emp -> modelMapper.map(emp, AppointsDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/appoints/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public AppointsDTO getAppoints(@PathVariable Long id) {
        return modelMapper.map(service.getOne(id), AppointsDTO.class);
    }

    @PostMapping("/appoints")
    @ResponseStatus(value = HttpStatus.CREATED)
    public AppointsDTO createAppoints(@RequestBody AppointsDTO appoints) {
        Appoints appoint = modelMapper.map(appoints, Appoints.class);
        Organization org = organizationRepository.findById(appoint.getOrganization().getId()).get();
        String operation = String.format("APPOINT %s IN UNIT %s", appoint.getEmployee().getFullName(), appoint.getAdminUnit().getName());
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), operation);
        if (Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")) {
            throw new ApiException("Appointment deletion request rejected by the hierarchy");
        }
        return modelMapper.map(service.create(appoint), AppointsDTO.class);
    }

    @PutMapping("/appoints")
    @ResponseStatus(value = HttpStatus.OK)
    public AppointsDTO updateAppoints(@Valid @RequestBody AppointsDTO appDTO) {
        Appoints app = modelMapper.map(appDTO, Appoints.class);
        Organization org = organizationRepository.findById(app.getOrganization().getId()).get();
        String operation = String.format("MUTATE %s IN UNIT %s", app.getEmployee().getFullName(), app.getAdminUnit().getName());
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), operation);
        if (Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")) {
            throw new ApiException("Appointment deletion request rejected by the hierarchy");
        }
        return modelMapper.map(service.create(app), AppointsDTO.class);
    }

    @DeleteMapping(value = "/appoints/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        Appoints app = service.getOne(id);
        Organization org = organizationRepository.findById(app.getOrganization().getId()).get();
        String operation = String.format("REMOVE %s IN UNIT %s", app.getEmployee().getFirstName(), app.getAdminUnit().getName());
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), operation);
        if (Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")) {
            throw new ApiException("Appointment deletion request rejected by the hierarchy");
        }
        service.delete(id);
    }

    private ResponseEntity<AppResponse> triggerApproval(Organization organization, Employee owner, String operation) {
        User approverUser = userService.getUserByEmployee(owner).get();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AccessRequest.AccessRequestBuilder builder = AccessRequest.builder().userId(principal.getUsername())
                .timeout(15)
                .priority(1)
                .requiredApproval(true)
                .approvalLevel(1)
                .operationId(operation)
                .resourceId("EMPLOYEES")
                .unit("ADMIN")
                .org(organization.getName())
                .status("ALLOWED")
                .approvalType(ApprovalType.SEQUENTIAL)
                .approvers(Collections.singletonList(
                        new Approver(approverUser.getUsername(), approverUser.getEmail(), null)));

        return approvalService.handleApproval(
                builder);
    }
}
