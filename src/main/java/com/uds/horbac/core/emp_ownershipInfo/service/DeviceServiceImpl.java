package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.DeviceRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.Device;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceRepository deviceRepository; 
	
	@Override
	public Device save(Device device) {
		return deviceRepository.save(device);
	}

	@Override
	public void delete(Long id) {
		deviceRepository.deleteById(id);
	}

	@Override
	public List<Device> getAll() {
		return deviceRepository.findAll();
	}

	@Override
	public Device getDevice(Long id) {
		return deviceRepository.getOne(id);
	}

}
