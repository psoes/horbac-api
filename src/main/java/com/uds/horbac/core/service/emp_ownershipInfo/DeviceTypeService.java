package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import com.uds.horbac.core.entities.emp_ownershipInfo.DeviceType;

public interface DeviceTypeService {
	
	/**
	 * Save a DeviceType
	 * @param DeviceType the DeviceType to save 
	 * @return Return the saved DeviceType
	 */	
	public DeviceType save(DeviceType deviceType);
	
	/**
	 * delete a DeviceType
	 * @param id 
	 * @return 
	 */	
	public void delete(Long id); 
	
	/**
	 * get all DeviceType
	 * @return Return the list DeviceType
	 */
	public List<DeviceType> getAll();
	
	/**
	 * find a DeviceType by Id
	 * @param id 
	 * @return Return the DeviceType found or null
	 */	
	public DeviceType getDeviceType(Long id);
}
