package com.uds.horbac.core.requests;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Action;
import com.uds.horbac.core.activities.entities.Activity;
import com.uds.horbac.core.contexts.Context;
import com.uds.horbac.core.employees.Approver;
import com.uds.horbac.core.employees.Emitter;
import com.uds.horbac.core.resources.Resource;
import com.uds.horbac.core.resources.Vue;

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
	private Context context;
	
	@ManyToOne
	private Action action;
	
	private Decision decision;
	
	
	
	
}

