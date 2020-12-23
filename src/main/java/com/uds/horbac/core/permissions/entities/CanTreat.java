package com.uds.horbac.core.permissions.entities;

import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Action;
import com.uds.horbac.core.employees.entities.Approver;
import com.uds.horbac.core.resources.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CanTreat

{
	
    /** Attributes */
    /**
     * 
     */
	@ManyToOne
    private Action action;
	
	@ManyToOne
	private Approver approver;
	
	@ManyToOne
	private Resource resource;

}

