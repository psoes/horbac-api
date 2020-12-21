package com.uds.horbac.core.clients.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String logo;
	
	/*
	 * url to redirect the user to after authentication
	 */
	private String redirect_url;
	
	/**
	 * a type of client can be web, desktop, mobile...
	 */
	@ManyToOne
	private ClientType type;


}
