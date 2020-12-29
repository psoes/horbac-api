package com.uds.horbac.core.emp_ownershipInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.emp_ownershipInfo.dao.TitreFoncierRepository;
import com.uds.horbac.core.emp_ownershipInfo.entities.TitreFoncier;

@Service
public class TitreFoncierServiceImpl implements TitreFoncierService {

	@Autowired
	TitreFoncierRepository titreFoncierRepository;
	
	@Override
	public TitreFoncier save(TitreFoncier titreFoncier) {
		return titreFoncierRepository.save(titreFoncier);
	}

	@Override
	public void delete(Long id) {
		titreFoncierRepository.deleteById(id);
	}

	@Override
	public List<TitreFoncier> getAll() {
		return titreFoncierRepository.findAll();
	}

	@Override
	public TitreFoncier getTitreFoncier(Long id) {
		return titreFoncierRepository.getOne(id);
	}

}
