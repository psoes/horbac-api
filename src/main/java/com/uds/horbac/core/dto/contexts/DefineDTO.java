package com.uds.horbac.core.dto.contexts;

import com.uds.horbac.core.dto.activities.ActionDTO;
import com.uds.horbac.core.dto.employees.EmployeeDTO;
import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.dto.resources.ResourceDTO;

import lombok.Data;

@Data
public class DefineDTO

{
    public Long id;
	
    private EmployeeDTO employee;

    private ContextDTO context;
	
    private ActionDTO action;
    
	private ResourceDTO resource;
	
	private OrganizationDTO organization;
}

