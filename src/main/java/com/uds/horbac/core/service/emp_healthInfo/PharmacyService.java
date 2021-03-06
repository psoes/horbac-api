package com.uds.horbac.core.service.emp_healthInfo;

import com.uds.horbac.core.dao.emp_healthInfo.PharmacyRepository;
import com.uds.horbac.core.entities.emp_healthInfo.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class PharmacyService {

	private PharmacyRepository pharmacyRepository;

	@Autowired
	public PharmacyService(PharmacyRepository pharmacyRepository) {
		this.pharmacyRepository = pharmacyRepository;
	}

}
