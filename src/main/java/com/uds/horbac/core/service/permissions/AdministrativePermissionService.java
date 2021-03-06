package com.uds.horbac.core.service.permissions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uds.horbac.core.dao.permissions.AdministrativePermissionRepository;
import com.uds.horbac.core.entities.permissions.AdministrativePermission;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class AdministrativePermissionService {
	
	@Autowired
	private AdministrativePermissionRepository apRepository;
	
	public List<AdministrativePermission> getAll() {
		return apRepository.findAll();
	}

	public void delete(Long id) {
		apRepository.deleteById(id);		
	}

	public AdministrativePermission save(AdministrativePermission aop) {
		return apRepository.save(aop);
	}

	public AdministrativePermission getAdminPermission(Long id) {
		return apRepository.findById(id).orElse(null);
	}
}
