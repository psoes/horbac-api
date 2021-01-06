package com.uds.horbac.core.service.emp_ownershipInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.emp_ownershipInfo.BiensImmobiliersRepository;
import com.uds.horbac.core.entities.emp_ownershipInfo.BiensImmobiliers;

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
