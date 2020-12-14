package com.uds.horbac.core.organizations.rest;

import java.util.List;
import java.util.stream.Collectors;

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

import com.uds.horbac.core.organizations.dto.OrganizationDTO;
import com.uds.horbac.core.organizations.entities.Organization;
import com.uds.horbac.core.organizations.service.OrganizationService;

@RestController
@RequestMapping(produces="application/json")
public class OrganizationController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private OrganizationService organizationService;

	
	@GetMapping("/organizations")
	@ResponseStatus(value=HttpStatus.OK)
	public List<OrganizationDTO> getorganizations() {
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
	public OrganizationDTO createOrganization(@RequestBody OrganizationDTO OrganizationDTO){
		
		Organization organization = modelMapper.map(OrganizationDTO, Organization.class);
		
		return modelMapper.map(organizationService.save(organization), OrganizationDTO.class);
	}
	
	@PutMapping("/organizations")
	@ResponseStatus(value=HttpStatus.OK)
	public OrganizationDTO  updateOrganization(@RequestBody OrganizationDTO organizationDTO) {
		
		Organization organization = modelMapper.map(organizationDTO, Organization.class);		
		return modelMapper.map(organizationService.save(organization), OrganizationDTO.class);
	}
	
	@DeleteMapping(value = "/organizations/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		organizationService.delete(id);
	}

}
