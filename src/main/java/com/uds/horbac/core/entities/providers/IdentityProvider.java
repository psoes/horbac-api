package com.uds.horbac.core.entities.providers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.organizations.Organization;

import lombok.Data;

@Data
@Entity
public class IdentityProvider {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@ManyToOne
	private Organization organization;
}
