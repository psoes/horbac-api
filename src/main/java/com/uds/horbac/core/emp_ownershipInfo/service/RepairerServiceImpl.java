package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.RepairerRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.Repairer;

@Service
public class RepairerServiceImpl implements RepairerService {

	@Autowired
	RepairerRepository repairerRepository; 
	
	@Override
	public Repairer save(Repairer repairer) {
		return repairerRepository.save(repairer);
	}

	@Override
	public void delete(Long id) {
		repairerRepository.deleteById(id);
	}

	@Override
	public List<Repairer> getAll() {
		return repairerRepository.findAll();
	}

	@Override
	public Repairer getRepairer(Long id) {
		return repairerRepository.getOne(id);
	}

}
