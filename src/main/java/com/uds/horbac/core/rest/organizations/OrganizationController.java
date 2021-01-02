package com.uds.horbac.core.rest.organizations;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.service.organizations.OrganizationService;

@RestController
@RequestMapping(produces="application/json")
public class OrganizationController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private OrganizationService organizationService;

	
	@GetMapping("/organizations")
	@ResponseStatus(value=HttpStatus.OK)
	public List<OrganizationDTO> getOrganizations() {
		List<Organization> orgs = organizationService.getAll();
		List<OrganizationDTO> orgsDTO = orgs.stream()
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
		Organization organization = modelMapper.map(orgDTO, Organization.class);
		
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

}
