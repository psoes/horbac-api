package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.emp_ownershipInfo.VehiculeTypeRepository;
import com.uds.horbac.core.entities.emp_ownershipInfo.VehiculeType;

@Service
public class VehiculeTypeServiceImpl implements VehiculeTypeService {

	@Autowired
	VehiculeTypeRepository vehiculeTypeRepository;
	
	@Override
	public VehiculeType save(VehiculeType vehiculeType) {
		return vehiculeTypeRepository.save(vehiculeType);
	}

	@Override
	public void delete(Long id) {
		vehiculeTypeRepository.deleteById(id);
	}

	@Override
	public List<VehiculeType> getAll() {
		return vehiculeTypeRepository.findAll();
	}

	@Override
	public VehiculeType getVehiculeType(Long id) {
		return vehiculeTypeRepository.getOne(id);
	}

}
