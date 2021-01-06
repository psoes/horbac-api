package com.uds.horbac.core.service.organizations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.organizations.OrganizationTypeRepository;
import com.uds.horbac.core.entities.organizations.OrganizationType;

@Service
public class OrganizationTypeServiceImpl implements OrganizationTypeService{
	
	@Autowired
	OrganizationTypeRepository organizationTypeRepository;

	@Override
	public OrganizationType save(OrganizationType type) {
		return organizationTypeRepository.save(type);
	}

	@Override
	public void delete(Long id) {
		organizationTypeRepository.deleteById(id);		
	}

	@Override
	public List<OrganizationType> getAll() {
		return organizationTypeRepository.findAll();
	}

	@Override
	public OrganizationType getOrganizationType(Long id) {
		return organizationTypeRepository.getOne(id);
	}


}
