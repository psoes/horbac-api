package com.uds.horbac.core.entities.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.organizations.Organization;

import lombok.Data;

@Data
@Entity
public class Uses
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
    private Resource resource;
	
	@ManyToOne
    private Vue vue;
	
	@ManyToOne
	private Organization organization;	
	
}

