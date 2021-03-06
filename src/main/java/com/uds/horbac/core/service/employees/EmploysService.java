package com.uds.horbac.core.service.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.employees.EmploysRepository;
import com.uds.horbac.core.entities.employees.Employs;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Service
public class EmploysService {
	@Autowired
	private EmploysRepository employsRepository;

	public List<Employs> getAll(){
		return employsRepository.findAll();
	}	
	public Employs create(Employs emp) {
		return employsRepository.save(emp);
	}	
	public Employs update(Employs emp) {
		return employsRepository.save(emp);
	}	
	public void delete(Long id) {
		employsRepository.deleteById(id);
	}	
	public Employs getOne(Long id) {
		return employsRepository.getOne(id);
	}

}
