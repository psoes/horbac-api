package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.emp_ownershipInfo.RepairerRepository;
import com.uds.horbac.core.entities.emp_ownershipInfo.Repairer;

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
