package com.uds.horbac.core.service.emp_educationInfo;

import com.uds.horbac.core.dao.emp_educationInfo.ScholarshipRepository;
import com.uds.horbac.core.entities.emp_educationInfo.Scholarship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class ScholarshipService {

	private ScholarshipRepository scholarshipRepository;

	@Autowired
	public ScholarshipService(ScholarshipRepository scholarshipRepository) {
		this.scholarshipRepository = scholarshipRepository;
	}

}