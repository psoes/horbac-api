package com.uds.horbac.core.service.employees;

import com.uds.horbac.core.dao.employees.AppointsRepository;
import com.uds.horbac.core.entities.employees.Appoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointsService {
	
	@Autowired
	private AppointsRepository appointsRepository;	
	public List<Appoints> getAll(){
		return appointsRepository.findAll();
	}	
	public Appoints create(Appoints apoints) {
		return appointsRepository.save(apoints);
	}	
	public Appoints update(Appoints apoints) {
		return appointsRepository.save(apoints);
	}	
	public void delete(Long id) {
		appointsRepository.deleteById(id);
	}	
	public Appoints getOne(Long id) {
		return appointsRepository.getOne(id);
	}

	
}
