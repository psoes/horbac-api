package com.uds.horbac.core.dto.resources;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;

import lombok.Data;

@Data
public class UsesDTO

{
   
    private Long id;

    private ResourceDTO resource;

    private VueDTO vue;

	private OrganizationDTO organization;
	
	
}

