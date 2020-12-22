package com.uds.horbac.core.resources_servers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.uds.horbac.core.clients.entities.Client;
import com.uds.horbac.core.users.entities.User;

import lombok.Data;

@Entity
@Data
public class AuthGrant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Client client;
	
	/**
	 * scopes granted by users
	 */
	@OneToMany
	@JoinColumn(name = "auth_id")
	private List<Scope> grantedScopes;
}
