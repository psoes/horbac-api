package com.uds.horbac.core.rest.permissions;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.uds.horbac.core.annotations.IsAllowed;
import com.uds.horbac.core.dao.organizations.OrganizationRepository;
import com.uds.horbac.core.entities.employees.Employee;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.permissions.ApprovalType;
import com.uds.horbac.core.entities.requests.AccessRequest;
import com.uds.horbac.core.entities.requests.AppResponse;
import com.uds.horbac.core.entities.users.Approver;
import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.security.ActivityType;
import com.uds.horbac.core.security.ViewType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.permissions.AdministrativePermissionDTO;
import com.uds.horbac.core.dto.permissions.OperationalPermissionDTO;
import com.uds.horbac.core.entities.permissions.AdministrativePermission;
import com.uds.horbac.core.entities.permissions.OperationalPermission;
import com.uds.horbac.core.exceptions.ApiException;
import com.uds.horbac.core.service.permissions.AdministrativePermissionService;
import com.uds.horbac.core.service.permissions.OperationalPermissionService;

@RestController
public class PermissionsController {

    protected @Autowired AdministrativePermissionService adminService;
    protected @Autowired OperationalPermissionService opService;
    protected @Autowired ModelMapper modelMapper;
	@Autowired
    UserService userService;

    @Autowired
    ApprovalService approvalService;
    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping(value = "/admin-grants")
    @IsAllowed(activity = ActivityType.VIEW, view = ViewType.PERMISSIONS)
    public List<AdministrativePermissionDTO> getAllAdminPermissions(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
        return adminService.getAll().stream()
                .map(def -> modelMapper.map(def, AdministrativePermissionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/admin-grants/{id}")
    @IsAllowed(activity = ActivityType.VIEW, view = ViewType.PERMISSIONS)
    @ResponseStatus(value = HttpStatus.OK)
    public AdministrativePermissionDTO getAdminPermissionById(@PathVariable Long id) {
        return modelMapper.map(adminService.getAdminPermission(id), AdministrativePermissionDTO.class);
    }

    @PostMapping("/admin-grants")
    @ResponseStatus(value = HttpStatus.CREATED)
    @IsAllowed(activity = ActivityType.CREATE, view = ViewType.PERMISSIONS)
    public AdministrativePermissionDTO createAdminPermission(@Valid @RequestBody AdministrativePermissionDTO defDTO) {
        AdministrativePermission def = modelMapper.map(defDTO, AdministrativePermission.class);

        return modelMapper.map(adminService.save(def), AdministrativePermissionDTO.class);
    }

    @PutMapping("/admin-grants/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @IsAllowed(activity = ActivityType.UPDATE, view = ViewType.PERMISSIONS)
    public AdministrativePermissionDTO updateAdminPermission(@PathVariable("id") Long id, @Valid @RequestBody AdministrativePermissionDTO defDTO) {
        if (adminService.getAdminPermission(id) == null) {
            throw new ApiException("PERMISSION OF ID " + id + " NOT FOUND");
        }
        AdministrativePermission def = modelMapper.map(defDTO, AdministrativePermission.class);
        return modelMapper.map(adminService.save(def), AdministrativePermissionDTO.class);
    }

    @DeleteMapping(value = "/admin-grants/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @IsAllowed(activity = ActivityType.DELETE, view = ViewType.PERMISSIONS)
    public void delete(@PathVariable Long id) {
        adminService.delete(id);
    }

    /////

    @GetMapping(value = "/operational-grants")
    @IsAllowed(activity = ActivityType.VIEW, view = ViewType.PERMISSIONS)
    public List<OperationalPermissionDTO> getAllOpePermissions(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
        return opService.getAll().stream()
                .map(def -> modelMapper.map(def, OperationalPermissionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/operational-grants/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @IsAllowed(activity = ActivityType.VIEW, view = ViewType.PERMISSIONS)
    public OperationalPermissionDTO getOpePermissionById(@PathVariable Long id) {
        return modelMapper.map(opService.getOperationalPermission(id), OperationalPermissionDTO.class);
    }

    @PostMapping("/operational-grants")
    @ResponseStatus(value = HttpStatus.CREATED)
    @IsAllowed(activity = ActivityType.CREATE, view = ViewType.PERMISSIONS)
    public OperationalPermissionDTO createOpePermission(@Valid @RequestBody OperationalPermissionDTO defDTO) {
        OperationalPermission def = modelMapper.map(defDTO, OperationalPermission.class);
        Organization org = organizationRepository.findById(def.getOrganization().getId()).get();
        String operation = String.format("GRANT <%s> PERMISSION TO UNIT <%s> ON VIEW <%s> IN CONTEXT <%s>", def.getActivity().getName(), def.getUnit().getName(), def.getVue().getName(), def.getContext().getName());
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), operation);
        if(Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")){
            throw new ApiException("Policy creation request rejected by the hierarchy");
        }
        return modelMapper.map(opService.save(def), OperationalPermissionDTO.class);
    }

    @PutMapping("/operational-grants/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @IsAllowed(activity = ActivityType.UPDATE, view = ViewType.PERMISSIONS)
    public OperationalPermissionDTO updateOpePermission(@PathVariable("id") Long id, @Valid @RequestBody OperationalPermissionDTO defDTO) {
        if (opService.getOperationalPermission(id) == null) {
            throw new ApiException("PERMISSION OF ID " + id + " NOT FOUND");
        }
        OperationalPermission def = modelMapper.map(defDTO, OperationalPermission.class);
        Organization org = organizationRepository.findById(def.getOrganization().getId()).get();
        String operation = String.format("GRANT <%s> PERMISSION TO UNIT <%s> ON VIEW <%s> IN CONTEXT <%s>", def.getActivity().getName(), def.getUnit().getName(), def.getVue().getName(), def.getContext().getName());
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), operation);
        if(Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")){
            throw new ApiException("Policy update request rejected by the hierarchy");
        }
        return modelMapper.map(opService.save(def), OperationalPermissionDTO.class);
    }

    @DeleteMapping(value = "/operational-grants/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @IsAllowed(activity = ActivityType.DELETE, view = ViewType.PERMISSIONS)
    public void deleteOperPermission(@PathVariable Long id) {
        OperationalPermission grant = opService.getOperationalPermission(id);
        Organization org = organizationRepository.findById(grant.getOrganization().getId()).get();
        String operation = String.format("REMOTE <%s> PERMISSION TO UNIT <%s> ON VIEW <%s> IN CONTEXT <%s>", grant.getActivity().getName(), grant.getUnit().getName(), grant.getVue().getName(), grant.getContext().getName());
        ResponseEntity<AppResponse> approvalResponse = triggerApproval(org, (Employee) org.getOwner(), "REMOVE");
        if(Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")){
            throw new ApiException("Policy deletion request rejected by the hierarchy");
        }
        opService.delete(id);
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
                .resourceId("PERMISSIONS")
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
