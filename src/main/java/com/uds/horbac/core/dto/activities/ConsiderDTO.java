package com.uds.horbac.core.dto.activities;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;

import lombok.Data;

@Data
public class ConsiderDTO {
	
	private Long id;
	
	
	private ActivityDTO activity;
	

	private ActionDTO action;
	

	private OrganizationDTO organization;

}
