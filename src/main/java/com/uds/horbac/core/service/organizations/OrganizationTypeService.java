package com.uds.horbac.core.service.organizations;

import java.util.List;

import com.uds.horbac.core.entities.organizations.OrganizationType;

public interface OrganizationTypeService {
	
	/**
	 * save an organizationType
	 * @param OrganizationType the OrganizationType to save
	 * @return Return the saved OrganizationType
	 */
	public OrganizationType save(OrganizationType organizationType);
	
	/**
	 * delete an organizationType by id
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * get all activities
	 * @return
	 */

	public List<OrganizationType> getAll();
	
	/**
	 * find organizationType by Id
	 * @param id
	 * @return return the OrganizationType found or null;
	 */
	public OrganizationType getOrganizationType(Long id);
}
