package com.uds.horbac.core.service.units;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uds.horbac.core.dao.units.SubordinateRepository;
import com.uds.horbac.core.entities.units.Subordinate;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class SubordinateService {
	
	@Autowired
	private SubordinateRepository subordinateRepository;
	
	public List<Subordinate> getAll() {
		return subordinateRepository.findAll();
	}

	public Subordinate getOne(Long id) {
		return subordinateRepository.findById(id).orElse(null);
	}

	public Subordinate save(Subordinate rs) {
		return subordinateRepository.save(rs);
	}

	public void delete(Long id) {
		subordinateRepository.deleteById(id);		
	}

}
