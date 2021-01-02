package com.uds.horbac.core.entities.clients;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
