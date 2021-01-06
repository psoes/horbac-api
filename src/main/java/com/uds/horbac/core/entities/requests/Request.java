package com.uds.horbac.core.entities.requests;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.activities.Action;
import com.uds.horbac.core.entities.activities.Activity;
import com.uds.horbac.core.entities.contexts.Context;
import com.uds.horbac.core.entities.employees.Approver;
import com.uds.horbac.core.entities.employees.Emitter;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.resources.Resource;
import com.uds.horbac.core.entities.resources.Vue;

import lombok.Data;

@Data
@Entity
public class Request

{
    /** Attributes */
    /**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /** Associations */
	@ManyToOne
    private Approver approver;
	
	@ManyToOne
    private Activity activity;
	
	@ManyToOne
	private Emitter emitter;
	
	@ManyToOne
	private Vue view;
	
	@ManyToOne
	private Resource resource;
	
	@ManyToOne 
	private Organization organization;
	
	@ManyToOne
	private Context context;
	
	@ManyToOne
	private Action action;
	
	private Decision decision;
	
	
}

