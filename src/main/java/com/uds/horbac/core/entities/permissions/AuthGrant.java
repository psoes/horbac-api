package com.uds.horbac.core.entities.permissions;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.uds.horbac.core.entities.clients.Client;
import com.uds.horbac.core.entities.resources.Scope;
import com.uds.horbac.core.entities.users.User;

import lombok.Data;

@Entity(name = "auth_grant")
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
