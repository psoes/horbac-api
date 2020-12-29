package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import com.uds.horbac.core.emp_ownershipInfo.entities.VehiculeType;

public interface VehiculeTypeService {
	
	/**
	 * Save a VehiculeType 
	 * @param VehiculeType the VehiculeType to save 
	 * @return Return the saved VehiculeType
	 */	
	public VehiculeType save(VehiculeType vehiculeType);
	
	/**
	 * delete a VehiculeType
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all VehiculeType 
	 * @return Return the list of VehiculeType
	 */
	public List<VehiculeType> getAll();
	
	/**
	 * find a VehiculeType by Id
	 * @param id 
	 * @return Return the VehiculeType found or null
	 */	
	public VehiculeType getVehiculeType(Long id);
}
