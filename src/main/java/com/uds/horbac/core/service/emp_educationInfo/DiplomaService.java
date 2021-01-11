package com.uds.horbac.core.service.emp_educationInfo;

import com.uds.horbac.core.dao.emp_educationInfo.DiplomaRepository;
import com.uds.horbac.core.entities.emp_educationInfo.Diploma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class DiplomaService {

	private DiplomaRepository diplomaRepository;

	@Autowired
	public DiplomaService(DiplomaRepository diplomaRepository) {
		this.diplomaRepository = diplomaRepository;
	}

}