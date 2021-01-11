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
    /** Attributes */
    /**
     * 
     */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    /** Associations */
	
	@ManyToOne
    private Resource resource;
	
	@ManyToOne
    private Vue view;
	
	@ManyToOne
	private Organization organization;
	
	
}

