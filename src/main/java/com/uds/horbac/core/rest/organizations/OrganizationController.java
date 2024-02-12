package com.uds.horbac.core.rest.organizations;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.users.User;
import com.uds.horbac.core.service.common.FileService;
import com.uds.horbac.core.service.organizations.OrganizationService;

@RestController
@RequestMapping(produces="application/json")
public class OrganizationController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	private OrganizationService organizationService;	
	@GetMapping("/organizations")
	@ResponseStatus(value=HttpStatus.OK)
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
	@ResponseStatus(value=HttpStatus.OK)
	public OrganizationDTO getOrganizationById(@PathVariable Long id){
		Organization organization = organizationService.getOrganization(id);
		return modelMapper.map(organization, OrganizationDTO.class);
	}
	
	@PostMapping("/organizations")
	@ResponseStatus(value=HttpStatus.CREATED)
	public OrganizationDTO createOrganization(@Valid @RequestBody OrganizationDTO orgDTO){
		//if(orgDTO.getUrl() != null) {orgDTO.setUrl(new URL(orgDTO.getUrl()));
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Organization organization = modelMapper.map(orgDTO, Organization.class);
		organization.setOwner(principal.getEmployee());
		return modelMapper.map(organizationService.save(organization), OrganizationDTO.class);
	}
	
	@PutMapping("/organizations")
	@ResponseStatus(value=HttpStatus.OK)
	public OrganizationDTO  updateOrganization(@Valid @RequestBody OrganizationDTO organizationDTO) {
		
		Organization organization = modelMapper.map(organizationDTO, Organization.class);		
		return modelMapper.map(organizationService.save(organization), OrganizationDTO.class);
	}
	
	@DeleteMapping(value = "/organizations/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		organizationService.delete(id);
	}
	
	@PostMapping(value = "/organizations/{id}/upload",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Resource> postImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {
		Resource r = fileService.uploadFile("ORG"+id, file);
		organizationService.updateLogo(r.getFilename(), id);	
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + r.getFilename() + "\"").body(r);
		
	}

}
