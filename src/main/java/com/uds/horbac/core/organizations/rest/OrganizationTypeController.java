package com.uds.horbac.core.organizations.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.organizations.dto.OrganizationTypeDTO;
import com.uds.horbac.core.organizations.entities.OrganizationType;
import com.uds.horbac.core.organizations.service.OrganizationTypeService;

@RestController
@RequestMapping(produces="application/json")
public class OrganizationTypeController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private OrganizationTypeService organizationTypeService;

	
	@GetMapping("/org-types")
	@ResponseStatus(value=HttpStatus.OK)
	public List<OrganizationTypeDTO> getorganizations() {
		List<OrganizationType> orgs = organizationTypeService.getAll();
		List<OrganizationTypeDTO> orgsDTO = orgs.stream()
				.map(type -> modelMapper.map(type, OrganizationTypeDTO.class))
				.collect(Collectors.toList());
		return orgsDTO;
	}
	
	@GetMapping("/org-types/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public OrganizationTypeDTO getOrganizationById(@PathVariable Long id){
		OrganizationType organizationType = organizationTypeService.getOrganizationType(id);
		return modelMapper.map(organizationType, OrganizationTypeDTO.class);
	}
	
	@PostMapping("/org-types")
	@ResponseStatus(value=HttpStatus.CREATED)
	public OrganizationTypeDTO createOrganization(@Validated @RequestBody OrganizationTypeDTO organizationTypeDTO){
		
		OrganizationType organizationType = modelMapper.map(organizationTypeDTO, OrganizationType.class);
		
		return modelMapper.map(organizationTypeService.save(organizationType), OrganizationTypeDTO.class);
	}
	
	@PutMapping("/org-types")
	@ResponseStatus(value=HttpStatus.OK)
	public OrganizationTypeDTO  updateOrganization(@RequestBody OrganizationTypeDTO organizationTypeDTO) {
		
		OrganizationType organizationType = modelMapper.map(organizationTypeDTO, OrganizationType.class);		
		return modelMapper.map(organizationTypeService.save(organizationType), OrganizationTypeDTO.class);
	}
	
	@DeleteMapping(value = "/org-types/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		organizationTypeService.delete(id);
	}

}
