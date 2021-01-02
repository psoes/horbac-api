package com.uds.horbac.core.dto.providers;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;

import lombok.Data;

@Data
public class IdentityProviderDTO {

	private Long id;
	
	private String issuer;
	
	private String authorization_url;
	
	private String token_url;
	
	/**
	 * a client id which has been registered  by the issuer
	 */
	private String client_id;
	
	/**
	 * the client secret obtained from the issuer
	 */
	private String client_secret;
	
	private OrganizationDTO organization;
}
