package com.uds.horbac.core.activities.dto;

import com.uds.horbac.core.organizations.dto.OrganizationDTO;

import lombok.Data;

@Data
public class ConsiderDTO {
	
	private Long id;
	
	
	private ActivityDTO activity;
	

	private ActionDTO action;
	

	private OrganizationDTO organization;

}
