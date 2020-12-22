package com.uds.horbac.core.users.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.organizations.entities.Organization;

import lombok.Data;

@Data
@Entity
public class ExternalIdentity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String subject;
	/*
	 * Organization to whom belongs the external identity of user
	 */
	@ManyToOne
	private Organization organization;
}
