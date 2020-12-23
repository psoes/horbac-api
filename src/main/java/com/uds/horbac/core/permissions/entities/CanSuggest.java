package com.uds.horbac.core.permissions.entities;

import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Action;
import com.uds.horbac.core.employees.entities.Emitter;
import com.uds.horbac.core.resources.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CanSuggest

{
    /** Attributes */
    /**
     * 
     */
	@ManyToOne
    private Action action;
	
	@ManyToOne
	private Emitter emitter;
	
	@ManyToOne
	private Resource resource;

}

