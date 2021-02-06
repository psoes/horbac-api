package com.uds.horbac.core.dto.units;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;

import lombok.Data;

@Data
public class SubordinateDTO

{

    private Long id;
    
    private OrganizationDTO organization;

    private AdministrativeUnitDTO subordinate;
	

    private AdministrativeUnitDTO superior;
}

