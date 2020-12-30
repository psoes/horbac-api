package com.uds.horbac.core.activities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.activities.dao.ConsiderRepository;
import com.uds.horbac.core.activities.entities.Consider;

@Service
public class ConsiderServiceImpl implements ConsiderService{
	
	@Autowired
	ConsiderRepository considerRepository;
	@Override
	public Consider save(Consider consider) {
		return considerRepository.save(consider);
	}

	@Override
	public void delete(Long id) {
		considerRepository.deleteById(id);
		
	}

	@Override
	public List<Consider> getAll() {
		return considerRepository.findAll();
	}

	@Override
	public Consider getConsider(Long id) {
		return considerRepository.getOne(id);
	}

	@Override
	public List<Consider> getConsidersByActionId(Long id) {
		return considerRepository.findByActionId(id);
	}

	@Override
	public Consider getConsidersByActionAndActivityAndOrg(Long idAction, Long idActivity, Long idOrg) {
		return considerRepository.findByActionIdAndActivityIdAndOrganizationId(idAction, idActivity, idOrg);
	}

	@Override
	public List<Consider> getConsidersByActivityId(Long id) {
		return considerRepository.findByActivityId(id);
	}

}
