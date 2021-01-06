package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import com.uds.horbac.core.entities.emp_ownershipInfo.Manufacturer;

public interface ManufacturerService {

	/**
	 * Save a Manufacturer 
	 * @param Manufacturer the Manufacturer to save 
	 * @return Return the saved Manufacturer
	 */	
	public Manufacturer save(Manufacturer manufacturer);
	
	/**
	 * delete a Manufacturer 
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all Manufacturer 
	 * @return Return the list Manufacturer
	 */
	public List<Manufacturer> getAll();
	
	/**
	 * find a Manufacturer by Id
	 * @param id 
	 * @return Return the Manufacturer found or null
	 */	
	public Manufacturer getManufacturer(Long id);
}
