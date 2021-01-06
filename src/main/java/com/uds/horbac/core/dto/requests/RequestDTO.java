package com.uds.horbac.core.dto.requests;
import com.uds.horbac.core.dto.activities.ActionDTO;
import com.uds.horbac.core.dto.activities.ActivityDTO;
import com.uds.horbac.core.dto.contexts.ContextDTO;
import com.uds.horbac.core.dto.employees.ApproverDTO;
import com.uds.horbac.core.dto.employees.EmitterDTO;
import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.dto.resources.ResourceDTO;
import com.uds.horbac.core.dto.resources.VueDTO;
import com.uds.horbac.core.entities.requests.Decision;

import lombok.Data;

@Data
public class RequestDTO

{
  
    private Long id;
 
    private ApproverDTO approver;

    private ActivityDTO activity;

	private EmitterDTO emitter;
	
	private VueDTO view;

	private ResourceDTO resource;
	

	private OrganizationDTO organization;
	

	private ContextDTO context;
	

	private ActionDTO action;
	
	private Decision decision;
	
	
}

