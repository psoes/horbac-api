package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import com.uds.horbac.core.entities.emp_ownershipInfo.Wheel;

public interface WheelService {
	
	/**
	 * Save a Wheel
	 * @param Wheel the Wheel to save 
	 * @return Return the saved Wheel
	 */	
	public Wheel save(Wheel wheel);
	
	/**
	 * delete a Wheel 
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all Wheel 
	 * @return Return the list of Wheel
	 */
	public List<Wheel> getAll();
	
	/**
	 * find a Wheel by Id
	 * @param id 
	 * @return Return the Wheel found or null
	 */	
	public Wheel getWheel(Long id);
}
