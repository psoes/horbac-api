package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.CarrosserieRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.Carrosserie;

@Service
public class CarrosserieServiceImpl implements CarrosserieService {

	@Autowired
	CarrosserieRepository carrosserieRepository;
	
	@Override
	public Carrosserie save(Carrosserie carrosserie) {
		return carrosserieRepository.save(carrosserie);
	}

	@Override
	public void delete(String id) {
		carrosserieRepository.deleteById(id);
	}

	@Override
	public List<Carrosserie> getAll() {
		return carrosserieRepository.findAll();
	}

	@Override
	public Carrosserie getCarrosserie(String id) {
		return carrosserieRepository.getOne(id);
	}

}
