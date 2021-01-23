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

import com.uds.horbac.core.dto.organizations.OrganizationTypeDTO;
import com.uds.horbac.core.entities.organizations.OrganizationType;
import com.uds.horbac.core.service.organizations.OrganizationTypeService;

@RestController
@RequestMapping(produces="application/json")
public class OrganizationTypeController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private OrganizationTypeService orgTypeService;	
	@GetMapping("/org-types")
	@ResponseStatus(value=HttpStatus.OK)
	public List<OrganizationTypeDTO> getOrganizations() {
		List<OrganizationType> orgs = orgTypeService.getAll();
		List<OrganizationTypeDTO> orgsDTO = orgs.stream()
				.map(type -> modelMapper.map(type, OrganizationTypeDTO.class))
				.collect(Collectors.toList());
		return orgsDTO;
	}
	
	@GetMapping("/org-types/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public OrganizationTypeDTO getOrganizationTypeById(@PathVariable Long id){
		OrganizationType type = orgTypeService.getOrganizationType(id);
		return modelMapper.map(type, OrganizationTypeDTO.class);
	}
	
	@PostMapping("/org-types")
	@ResponseStatus(value=HttpStatus.CREATED)
	public OrganizationTypeDTO createOrganization(@Valid @RequestBody OrganizationTypeDTO orgDTO){
		//if(orgDTO.getUrl() != null) {orgDTO.setUrl(new URL(orgDTO.getUrl()));
		OrganizationType type = modelMapper.map(orgDTO, OrganizationType.class);
		
		return modelMapper.map(orgTypeService.save(type), OrganizationTypeDTO.class);
	}
	
	@PutMapping("/org-types")
	@ResponseStatus(value=HttpStatus.OK)
	public OrganizationTypeDTO  updateOrganization(@Valid @RequestBody OrganizationTypeDTO typeDTO) {		
		OrganizationType type = modelMapper.map(typeDTO, OrganizationType.class);		
		return modelMapper.map(orgTypeService.save(type), OrganizationTypeDTO.class);
	}
	
	@DeleteMapping(value = "/org-types/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		orgTypeService.delete(id);
	}

}
