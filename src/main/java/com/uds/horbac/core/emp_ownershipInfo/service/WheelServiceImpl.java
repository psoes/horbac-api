package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.WheelRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.Wheel;

@Service
public class WheelServiceImpl implements WheelService {

	@Autowired
	WheelRepository wheelRepository;
	
	@Override
	public Wheel save(Wheel wheel) {
		return wheelRepository.save(wheel);
	}

	@Override
	public void delete(Long id) {
		wheelRepository.deleteById(id);
	}

	@Override
	public List<Wheel> getAll() {
		return wheelRepository.findAll();
	}

	@Override
	public Wheel getWheel(Long id) {
		return wheelRepository.getOne(id);
	}

}
