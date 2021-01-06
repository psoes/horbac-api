package com.uds.horbac.core.dto.users;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;

import lombok.Data;

@Data
public class ExternalIdentityDTO {
	
	private Long id;
	
	private String subject;
	
	private OrganizationDTO organization;
}
