package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import com.uds.horbac.core.emp_ownershipInfo.entities.Vehicle;

public interface VehiculeService {
	
	/**
	 * Save a Vehicle
	 * @param Vehicule the Vehicle to save 
	 * @return Return the saved Vehicle
	 */	
	public Vehicle save(Vehicle vehicule);
	
	/**
	 * delete a Vehicle
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all Vehicle
	 * @return Return the list of Vehicle
	 */
	public List<Vehicle> getAll();
	
	/**
	 * find a Vehicle by Id
	 * @param id 
	 * @return Return the Vehicle found or null
	 */	
	public Vehicle getVehicule(Long id);
}
