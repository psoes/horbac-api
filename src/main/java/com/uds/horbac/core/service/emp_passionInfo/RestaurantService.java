package com.uds.horbac.core.service.emp_passionInfo;

import com.uds.horbac.core.dao.emp_passionInfo.RestaurantRepository;
import com.uds.horbac.core.entities.emp_passionInfo.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class RestaurantService {

	private RestaurantRepository restaurantRepository;

	@Autowired
	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

}
