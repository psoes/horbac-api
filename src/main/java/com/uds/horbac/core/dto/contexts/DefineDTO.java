package com.uds.horbac.core.dto.contexts;

import javax.persistence.ManyToOne;

import com.uds.horbac.core.dto.activities.ActionDTO;
import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.dto.resources.ResourceDTO;
import com.uds.horbac.core.entities.employees.Employee;

import lombok.Data;

@Data
public class DefineDTO

{

    public Long id;
    /** Associations */
	

    private Employee employee;


    private ContextDTO context;
	

    private ActionDTO action;
	
	@ManyToOne
	private ResourceDTO resource;
	
	@ManyToOne
	private OrganizationDTO organization;
}

