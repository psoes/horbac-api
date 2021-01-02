package com.uds.horbac.core.entities.activities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.organizations.Organization;

import lombok.Data;

@Entity
@Data
public class Consider

{
    /** Attributes */
    /**
     * 
     */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
	private Activity activity;
	
	@ManyToOne
	private Action action;
	
	@ManyToOne
	private Organization organization;
	
	
}

