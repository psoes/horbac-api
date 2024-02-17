package com.uds.horbac.core.rest.organizations;

import com.uds.horbac.core.dao.units.AdminUnitSimpleRepository;
import com.uds.horbac.core.dto.organizations.NewOrganizationDTO;
import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.entities.employees.Appoints;
import com.uds.horbac.core.entities.employees.Employee;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.permissions.ApprovalType;
import com.uds.horbac.core.entities.requests.AccessRequest;
import com.uds.horbac.core.entities.requests.AppResponse;
import com.uds.horbac.core.entities.units.AdministrativeUnit;
import com.uds.horbac.core.entities.users.Approver;
import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.exceptions.ApiException;
import com.uds.horbac.core.service.common.FileService;
import com.uds.horbac.core.service.employees.AppointsService;
import com.uds.horbac.core.service.employees.EmployeeService;
import com.uds.horbac.core.service.organizations.OrganizationService;
import com.uds.horbac.core.service.users.UserService;
import com.uds.horbac.integration.ApprovalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(produces = "application/json")
public class OrganizationController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FileService fileService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AdminUnitSimpleRepository adminUnitSimpleRepository;

    @Autowired
    AppointsService appointsService;

    @Autowired
    UserService userService;

    @Autowired
    ApprovalService approvalService;

    @GetMapping("/organizations")
    @ResponseStatus(value = HttpStatus.OK)
    public List<OrganizationDTO> getOrganizations() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Organization> orgs = organizationService.getAll();
        List<OrganizationDTO> orgsDTO = orgs.stream()
                //.filter(org -> org.getOwner()== null || (org.getOwner() != null && org.getOwner().getId() == principal.getId()))
                .map(cycle -> modelMapper.map(cycle, OrganizationDTO.class))
                .collect(Collectors.toList());
        return orgsDTO;
    }

    @GetMapping("/organizations/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public OrganizationDTO getOrganizationById(@PathVariable Long id) {
        Organization organization = organizationService.getOrganization(id);
        return modelMapper.map(organization, OrganizationDTO.class);
    }

    @PostMapping("/organizations")
    @ResponseStatus(value = HttpStatus.CREATED)
    public OrganizationDTO createOrganization(@Valid @RequestBody OrganizationDTO orgDTO) {
        //if(orgDTO.getUrl() != null) {orgDTO.setUrl(new URL(orgDTO.getUrl()));
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Organization organization = modelMapper.map(orgDTO, Organization.class);
        organization.setOwner(principal.getEmployee());
        return modelMapper.map(organizationService.save(organization), OrganizationDTO.class);
    }

    @PostMapping("/organizations/new")
    @ResponseStatus(value = HttpStatus.CREATED)
    public OrganizationDTO createOrganizationWithApproval(@Valid @RequestBody NewOrganizationDTO orgRequest) {
        //if(orgDTO.getUrl() != null) {orgDTO.setUrl(new URL(orgDTO.getUrl()));
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Organization organization = modelMapper.map(orgRequest.getOrganization(), Organization.class);
        Employee owner = modelMapper.map(orgRequest.getOwner(), Employee.class);
        AdministrativeUnit root = modelMapper.map(orgRequest.getRoot(), AdministrativeUnit.class);

        owner = employeeService.save(owner);

        organization.setOwner(owner);
        organization.setPendingApproval(true);

        ResponseEntity<AppResponse> approvalResponse = triggerApproval(organization, owner);
        if(Objects.equals(approvalResponse.getBody().getDecision(), "DENIED")){
            throw new ApiException("Organization creation request rejected by the hierarchy");
        }
        organization.setPendingApproval(false);
        organization = organizationService.save(organization);

        root.setOrganization(organization);
        root = adminUnitSimpleRepository.save(root);

        appointsService.create(
                Appoints.builder().organization(organization).adminUnit(root).employee(owner).build()
        );

        return modelMapper.map(organization, OrganizationDTO.class);
    }

    @PutMapping("/organizations")
    @ResponseStatus(value = HttpStatus.OK)
    public OrganizationDTO updateOrganization(@Valid @RequestBody OrganizationDTO organizationDTO) {

        Organization organization = modelMapper.map(organizationDTO, Organization.class);
        return modelMapper.map(organizationService.save(organization), OrganizationDTO.class);
    }

    @DeleteMapping(value = "/organizations/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        organizationService.delete(id);
    }

    @PostMapping(value = "/organizations/{id}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Resource> postImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {
        Resource r = fileService.uploadFile("ORG" + id, file);
        organizationService.updateLogo(r.getFilename(), id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + r.getFilename() + "\"").body(r);

    }

    private ResponseEntity<AppResponse> triggerApproval(Organization organization, Employee owner) {
        User approverUser = userService.getUserByEmployee(owner).get();
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AccessRequest.AccessRequestBuilder builder = AccessRequest.builder().userId(principal.getUsername())
                .timeout(15)
                .priority(1)
                .requiredApproval(true)
                .approvalLevel(1)
                .operationId("CREATE")
                .resourceId("ORGANIZATION")
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
