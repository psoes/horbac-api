package com.uds.horbac.core.service.employees;

import com.uds.horbac.core.dao.employees.AppointsRepository;
import com.uds.horbac.core.entities.employees.Appoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class AppointsService {

	private AppointsRepository appointsRepository;

	@Autowired
	public AppointsService(AppointsRepository appointsRepository) {
		this.appointsRepository = appointsRepository;
	}

}
