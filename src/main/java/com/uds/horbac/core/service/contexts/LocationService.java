package com.uds.horbac.core.service.contexts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uds.horbac.core.dao.contexts.LocationRepository;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class LocationService {
	
	private LocationRepository locationRepository;

	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

}
