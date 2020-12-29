package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.DeviceTypeRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.DeviceType;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

	@Autowired
	DeviceTypeRepository deviceTypeRepository;
	
	@Override
	public DeviceType save(DeviceType deviceType) {
		return deviceTypeRepository.save(deviceType);
	}

	@Override
	public void delete(Long id) {
		deviceTypeRepository.deleteById(id);
	}

	@Override
	public List<DeviceType> getAll() {
		return deviceTypeRepository.findAll();
	}

	@Override
	public DeviceType getDeviceType(Long id) {
		return deviceTypeRepository.getOne(id);
	}
	
}
