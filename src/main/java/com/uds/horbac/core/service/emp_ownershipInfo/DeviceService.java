package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import com.uds.horbac.core.entities.emp_ownershipInfo.Device;

public interface DeviceService {
	
	/**
	 * Save a Device
	 * @param Device the Device to save 
	 * @return Return the saved Device
	 */	
	public Device save(Device device);
	
	/**
	 * delete a Device
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all Device
	 * @return Return the list of Device
	 */
	public List<Device> getAll();
	
	/**
	 * find a Device by Id
	 * @param id 
	 * @return Return the Device found or null
	 */	
	public Device getDevice(Long id);
}
