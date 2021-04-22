package com.uds.horbac.core.service.organizations;

import java.util.List;

import com.uds.horbac.core.entities.employees.Employee;
import com.uds.horbac.core.entities.organizations.Organization;

public interface OrganizationService {
	
	/**
	 * save an Organization
	 * @param Organization the Organization to save
	 * @return Return the saved Organization
	 */
	public Organization save(Organization organization);
	
	/**
	 * delete an Organization by id
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * get all activities
	 * @return
	 */

	public List<Organization> getAll();
	
	/**
	 * find Organization by Id
	 * @param id
	 * @return return the Organization found or null;
	 */
	public Organization getOrganization(Long id);
	
	public void updateLogo(String logo, Long id);

	public List<Organization> getAllByOwner(Employee employee);
}
