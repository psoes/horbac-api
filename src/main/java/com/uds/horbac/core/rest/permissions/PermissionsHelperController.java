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
import com.uds.horbac.core.dto.permissions.OperationalPermissionDTO;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.permissions.AdministrativePermission;
import com.uds.horbac.core.entities.permissions.CanSuggest;
import com.uds.horbac.core.entities.permissions.CanTreat;
import com.uds.horbac.core.entities.permissions.OperationalPermission;
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
    	List<OperationalPermission> resp = permissionService.canSuggest(org, cans);
    	if(resp != null ) return resp.stream()
				.map(def -> modelMapper.map(def, OperationalPermissionDTO.class))
				.collect(Collectors.toList());
    	else return null;
    }
     
    @PostMapping("/admin-helpers/{id}")
    public List<AdministrativePermissionDTO> canTreat(@PathVariable("id")Long orgId, @RequestBody CanTreat can) {
    	Organization org = orgService.getOrganization(orgId);
    	//CanTreat can = modelMapper.map(cant, CanTreat.class);
    	List<AdministrativePermission> adm = permissionService.canTreat(org, can);
    	if(adm != null)return adm.stream()
				.map(def -> modelMapper.map(def, AdministrativePermissionDTO.class))
				.collect(Collectors.toList());
    	else return null;
    }
}
