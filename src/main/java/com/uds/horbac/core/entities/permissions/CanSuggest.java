package com.uds.horbac.core.entities.permissions;

import com.uds.horbac.core.entities.activities.Action;
import com.uds.horbac.core.entities.employees.Emitter;
import com.uds.horbac.core.entities.resources.Resource;

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
    private Action action;
	
	private Emitter emitter;
	
	private Resource resource;

}

