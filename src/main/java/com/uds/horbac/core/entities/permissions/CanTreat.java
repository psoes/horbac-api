package com.uds.horbac.core.entities.permissions;

import com.uds.horbac.core.entities.activities.Action;
import com.uds.horbac.core.entities.employees.Approver;
import com.uds.horbac.core.entities.resources.Resource;

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
    private Action action;
	

	private Approver approver;
	

	private Resource resource;

}

