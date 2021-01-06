package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.emp_ownershipInfo.RepairerSpecialityRepository;
import com.uds.horbac.core.entities.emp_ownershipInfo.RepairerSpeciality;

@Service
public class RepairerSpecialityServiceImpl implements RepairerSpecialityService {

	@Autowired
	RepairerSpecialityRepository repairerSpecialityRepository;
	
	@Override
	public RepairerSpeciality save(RepairerSpeciality repairerSpeciality) {
		return repairerSpecialityRepository.save(repairerSpeciality);
	}

	@Override
	public void delete(Long id) {
		repairerSpecialityRepository.deleteById(id);
	}

	@Override
	public List<RepairerSpeciality> getAll() {
		return repairerSpecialityRepository.findAll();
	}

	@Override
	public RepairerSpeciality getRepairerSpeciality(Long id) {
		return repairerSpecialityRepository.getOne(id);
	}

}
