package com.uds.horbac.core.service.organizations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.organizations.OrganizationTypeRepository;
import com.uds.horbac.core.entities.organizations.OrganizationType;

@Service
public class OrganizationTypeService{
	
	@Autowired
	OrganizationTypeRepository repository;

	public OrganizationType save(OrganizationType type) {
		return repository.save(type);
	}

	public void delete(Long id) {
		repository.deleteById(id);		
	}

	public List<OrganizationType> getAll() {
		return repository.findAll();
	}

	public OrganizationType getOrganizationType(Long id) {
		return repository.getOne(id);
	}


}
