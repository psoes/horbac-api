package com.uds.horbac.core.rest.employees;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.uds.horbac.core.dao.organizations.OrganizationRepository;
import com.uds.horbac.core.entities.employees.Employee;
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

import com.uds.horbac.core.dto.employees.EmploysDTO;
import com.uds.horbac.core.entities.employees.Employs;
import com.uds.horbac.core.service.employees.EmploysService;

@RestController
public class EmploysController {

    protected @Autowired EmploysService service;
    protected @Autowired ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Autowired
    ApprovalService approvalService;
    @Autowired
    private OrganizationRepository organizationRepository;

    @RequestMapping(value = "/employs", method = GET)
    public List<EmploysDTO> getAll(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
        return service.getAll().stream()
                .map(emp -> modelMapper.map(emp, EmploysDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/employs/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public EmploysDTO getEmploys(@PathVariable Long id) {
        return modelMapper.map(service.getOne(id), EmploysDTO.class);
    }

    @PostMapping("/employs")
    @ResponseStatus(value = HttpStatus.CREATED)
    public EmploysDTO createEmploys(@RequestBody EmploysDTO emp) {
        Employs empl = modelMapper.map(emp, Employs.class);
        Organization org = organizationRepository.findById(empl.getOrganization().getId()).get();
        String operation = String.format("EMPLOY %s IN UNIT %s", empl.getEmployee().getFullName(), empl.getOperationalUnit().getName());
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), operation);
        if (Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")) {
            throw new ApiException("Employment request rejected by the hierarchy");
        }

        return modelMapper.map(service.create(empl), EmploysDTO.class);
    }

    @PutMapping("/employs")
    @ResponseStatus(value = HttpStatus.OK)
    public EmploysDTO updateEmploys(@Valid @RequestBody EmploysDTO empDTO) {
        Employs app = modelMapper.map(empDTO, Employs.class);
        Employs empl = service.getOne(app.getId());
        String operation = String.format("MUTATE %s IN UNIT %s", empl.getEmployee().getFullName(), empl.getOperationalUnit().getName());
        Organization org = organizationRepository.findById(empl.getOrganization().getId()).get();
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), operation);
        if (Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")) {
            throw new ApiException("Employment update request rejected by the hierarchy");
        }
        return modelMapper.map(service.create(app), EmploysDTO.class);
    }

    @DeleteMapping(value = "/employs/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {

        Employs empl = service.getOne(id);
        String operation = String.format("REMOVE %s IN UNIT %s", empl.getEmployee().getFullName(), empl.getOperationalUnit().getName());
        Organization org = organizationRepository.findById(empl.getOrganization().getId()).get();
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), operation);

        if (Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")) {
            throw new ApiException("Employment deletion request rejected by the hierarchy");
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
