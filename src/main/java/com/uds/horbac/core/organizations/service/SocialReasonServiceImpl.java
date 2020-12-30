package com.uds.horbac.core.organizations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.organizations.dao.SocialReasonRepository;
import com.uds.horbac.core.organizations.entities.SocialReason;

@Service
public class SocialReasonServiceImpl implements SocialReasonService{
	
	@Autowired
	SocialReasonRepository socialReasonRepository;
	@Override
	public SocialReason save(SocialReason socialReason) {
		return socialReasonRepository.save(socialReason);
	}

	@Override
	public void delete(Long id) {
		socialReasonRepository.deleteById(id);		
	}

	@Override
	public List<SocialReason> getAll() {
		return socialReasonRepository.findAll();
	}

	@Override
	public SocialReason getsocialReason(Long id) {
		return socialReasonRepository.getOne(id);
	}

}
