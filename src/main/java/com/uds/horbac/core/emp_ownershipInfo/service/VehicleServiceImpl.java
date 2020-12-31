package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.VehicleRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository; 
	
	@Override
	public Vehicle save(Vehicle vehicule) {
		return vehicleRepository.save(vehicule);
	}

	@Override
	public void delete(Long id) {
		vehicleRepository.deleteById(id);
	}

	@Override
	public List<Vehicle> getAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle getVehicle(Long id) {
		return vehicleRepository.getOne(id);
	}

}
