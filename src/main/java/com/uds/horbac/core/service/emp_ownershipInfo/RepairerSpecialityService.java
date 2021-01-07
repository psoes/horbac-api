package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import com.uds.horbac.core.entities.emp_ownershipInfo.RepairerSpeciality;

public interface RepairerSpecialityService {
	
	/**
	 * Save a RepairerSpeciality
	 * @param RepairerSpeciality the RepairerSpeciality to save 
	 * @return Return the saved RepairerSpeciality
	 */	
	public RepairerSpeciality save(RepairerSpeciality repairerSpeciality);
	
	/**
	 * delete a RepairerSpeciality
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all RepairerSpeciality 
	 * @return Return the list of RepairerSpeciality
	 */
	public List<RepairerSpeciality> getAll();
	
	/**
	 * find a RepairerSpeciality by Id
	 * @param id 
	 * @return Return the RepairerSpeciality found or null
	 */	
	public RepairerSpeciality getRepairerSpeciality(Long id);
}
