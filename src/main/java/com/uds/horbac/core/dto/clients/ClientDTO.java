package com.uds.horbac.core.dto.clients;

import lombok.Data;

@Data
public class ClientDTO {

	private Long id;
	
	private String name;
	
	private String logo;
	
	/*
	 * url to redirect the user to after authentication
	 */
	private String redirect_url;
	
	private ClientTypeDTO type;


}
