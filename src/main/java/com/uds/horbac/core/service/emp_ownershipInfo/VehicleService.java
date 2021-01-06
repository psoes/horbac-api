package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import com.uds.horbac.core.entities.emp_ownershipInfo.Vehicle;

public interface VehicleService {
	
	/**
	 * Save a Vehicle
	 * @param Vehicule the Vehicle to save 
	 * @return Return the saved Vehicle
	 */	
	public Vehicle save(Vehicle vehicle);
	
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
	public Vehicle getVehicle(Long id);
}
