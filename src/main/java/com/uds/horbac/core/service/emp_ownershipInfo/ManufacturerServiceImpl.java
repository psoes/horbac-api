package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.emp_ownershipInfo.ManufacturerRepository;
import com.uds.horbac.core.entities.emp_ownershipInfo.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	@Override
	public Manufacturer save(Manufacturer manufacturer) {
		return manufacturerRepository.save(manufacturer);
	}

	@Override
	public void delete(Long id) {
		manufacturerRepository.deleteById(id);
	}

	@Override
	public List<Manufacturer> getAll() {
		return manufacturerRepository.findAll();
	}

	@Override
	public Manufacturer getManufacturer(Long id) {
		return manufacturerRepository.getOne(id);
	}

}
