package com.uds.horbac.core.organizations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.organizations.dao.OrganizationRepository;
import com.uds.horbac.core.organizations.entities.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	public Organization save(Organization organization) {
		return organizationRepository.save(organization);
	}

	@Override
	public void delete(Long id) {
		organizationRepository.deleteById(id);		
	}

	@Override
	public List<Organization> getAll() {
		return organizationRepository.findAll();
	}

	@Override
	public Organization getOrganization(Long id) {
		return organizationRepository.getOne(id);
	}


}
