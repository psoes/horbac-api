package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.VehiculeRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.Vehicle;

@Service
public class VehiculeServiceImpl implements VehiculeService {

	@Autowired
	VehiculeRepository vehiculeRepository; 
	
	@Override
	public Vehicle save(Vehicle vehicule) {
		return vehiculeRepository.save(vehicule);
	}

	@Override
	public void delete(Long id) {
		vehiculeRepository.deleteById(id);
	}

	@Override
	public List<Vehicle> getAll() {
		return vehiculeRepository.findAll();
	}

	@Override
	public Vehicle getVehicule(Long id) {
		return vehiculeRepository.getOne(id);
	}

}
