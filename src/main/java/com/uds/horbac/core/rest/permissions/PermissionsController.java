package com.uds.horbac.core.rest.permissions;

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
    
    @GetMapping(value = "/admin-grants")
    public List<AdministrativePermissionDTO> getAllAdminPermissions(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return adminService.getAll().stream()
				.map(def -> modelMapper.map(def, AdministrativePermissionDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/admin-grants/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public AdministrativePermissionDTO getAdminPermissionById(@PathVariable Long id){
		return modelMapper.map(adminService.getAdminPermission(id), AdministrativePermissionDTO.class);
	}
	
	@PostMapping("/admin-grants")
	@ResponseStatus(value=HttpStatus.CREATED)
	public AdministrativePermissionDTO createAdminPermission(@Valid @RequestBody AdministrativePermissionDTO defDTO){
		AdministrativePermission def = modelMapper.map(defDTO, AdministrativePermission.class);
		
		return modelMapper.map(adminService.save(def), AdministrativePermissionDTO.class);
	}
	
	@PutMapping("/admin-grants/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public AdministrativePermissionDTO  updateAdminPermission(@PathVariable("id") Long id,  @Valid @RequestBody AdministrativePermissionDTO defDTO) {		
		if(adminService.getAdminPermission(id) == null) {
			throw new ApiException("PERMISSION OF ID "+id+" NOT FOUND");
		}
		AdministrativePermission def = modelMapper.map(defDTO, AdministrativePermission.class);		
		return modelMapper.map(adminService.save(def), AdministrativePermissionDTO.class);
	}
	
	@DeleteMapping(value = "/admin-grants/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable Long id){
		adminService.delete(id);
	}
	
	/////
    
    @GetMapping(value = "/operational-grants")
    public List<OperationalPermissionDTO> getAllOpePermissions(@RequestParam(value = "start", defaultValue = "0") long start, @RequestParam(value = "limit", defaultValue = "25") long limit) {
    	return opService.getAll().stream()
				.map(def -> modelMapper.map(def, OperationalPermissionDTO.class))
				.collect(Collectors.toList());
    }
    
    @GetMapping("/operational-grants/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public OperationalPermissionDTO getOpePermissionById(@PathVariable Long id){
		return modelMapper.map(opService.getOperationalPermission(id), OperationalPermissionDTO.class);
	}
	
	@PostMapping("/operational-grants")
	@ResponseStatus(value=HttpStatus.CREATED)
	public OperationalPermissionDTO createOpePermission(@Valid @RequestBody OperationalPermissionDTO defDTO){
		OperationalPermission def = modelMapper.map(defDTO, OperationalPermission.class);
		
		return modelMapper.map(opService.save(def), OperationalPermissionDTO.class);
	}
	
	@PutMapping("/operational-grants/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public OperationalPermissionDTO  updateOpePermission(@PathVariable("id") Long id,  @Valid @RequestBody OperationalPermissionDTO defDTO) {		
		if(opService.getOperationalPermission(id) == null) {
			throw new ApiException("PERMISSION OF ID "+id+" NOT FOUND");
		}
		OperationalPermission def = modelMapper.map(defDTO, OperationalPermission.class);		
		return modelMapper.map(opService.save(def), OperationalPermissionDTO.class);
	}
	
	@DeleteMapping(value = "/operational-grants/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteOperPermission(@PathVariable Long id){
		opService.delete(id);
	}
	
	

}
