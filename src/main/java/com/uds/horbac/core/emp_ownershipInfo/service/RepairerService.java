package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import com.uds.horbac.core.emp_ownershipInfo.entities.Repairer;

public interface RepairerService {
	
	/**
	 * Save a Repairer
	 * @param Repairer the Repairer to save 
	 * @return Return the saved Repairer
	 */	
	public Repairer save(Repairer repairer);
	
	/**
	 * delete a Repairer 
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all Repairer 
	 * @return Return the list Repairer
	 */
	public List<Repairer> getAll();
	
	/**
	 * find a Repairer by Id
	 * @param id 
	 * @return Return the Repairer found or null
	 */	
	public Repairer getRepairer(Long id);
}
