package com.uds.horbac.core.service.emp_passionInfo;

import com.uds.horbac.core.dao.emp_passionInfo.SewingStyleRepository;
import com.uds.horbac.core.entities.emp_passionInfo.SewingStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Component
public class SewingStyleService {

	private SewingStyleRepository sewingStyleRepository;

	@Autowired
	public SewingStyleService(SewingStyleRepository sewingStyleRepository) {
		this.sewingStyleRepository = sewingStyleRepository;
	}

}
