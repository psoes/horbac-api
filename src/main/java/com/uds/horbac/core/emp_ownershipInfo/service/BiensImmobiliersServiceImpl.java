package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.BiensImmobiliersRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.BiensImmobiliers;

@Service
public class BiensImmobiliersServiceImpl implements BiensImmobiliersService {

	@Autowired
	BiensImmobiliersRepository biensImmobiliersRepository;
	
	@Override
	public BiensImmobiliers save(BiensImmobiliers biensImmobiliers) {
		return biensImmobiliersRepository.save(biensImmobiliers);
	}

	@Override
	public void delete(Long id) {
		biensImmobiliersRepository.deleteById(id);
	}

	@Override
	public List<BiensImmobiliers> getAll() {
		return biensImmobiliersRepository.findAll();
	}

	@Override
	public BiensImmobiliers getBiensImmobiliers(Long id) {
		return biensImmobiliersRepository.getOne(id);
	}

}
