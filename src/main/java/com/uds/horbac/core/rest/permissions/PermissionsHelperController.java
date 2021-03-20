package com.uds.horbac.core.rest.permissions;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.dto.permissions.AdministrativePermissionDTO;
import com.uds.horbac.core.dto.permissions.CanSuggestDTO;
import com.uds.horbac.core.dto.permissions.CanTreatDTO;
import com.uds.horbac.core.dto.permissions.OperationalPermissionDTO;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.permissions.CanSuggest;
import com.uds.horbac.core.entities.permissions.CanTreat;
import com.uds.horbac.core.service.organizations.OrganizationService;
import com.uds.horbac.core.service.permissions.PermissionHelperService;

@RestController
public class PermissionsHelperController {
	
	protected @Autowired PermissionHelperService permissionService;  
	protected @Autowired OrganizationService orgService; 
    protected @Autowired ModelMapper modelMapper;
    
    @PostMapping("/operational-helpers/{id}")
    public List<OperationalPermissionDTO> canSuggest(@PathVariable("id")Long orgId, @RequestBody CanSuggest cans) {
    	Organization org = orgService.getOrganization(orgId);
    	//CanSuggest can = modelMapper.map(cans, CanSuggest.class);
    	return permissionService.canSuggest(org, cans).stream()
				.map(def -> modelMapper.map(def, OperationalPermissionDTO.class))
				.collect(Collectors.toList());
    }
     
    @PostMapping("/admin-helpers/{id}")
    public List<AdministrativePermissionDTO> canTreat(@PathVariable("id")Long orgId, @RequestBody CanTreat can) {
    	Organization org = orgService.getOrganization(orgId);
    	//CanTreat can = modelMapper.map(cant, CanTreat.class);
    	return permissionService.canTreat(org, can).stream()
				.map(def -> modelMapper.map(def, AdministrativePermissionDTO.class))
				.collect(Collectors.toList());
    }
}
