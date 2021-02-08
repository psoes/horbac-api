package com.uds.horbac.core.dto.units;

import com.uds.horbac.core.dto.organizations.OrganizationDTO;

import lombok.Data;

@Data
public class PlaceUnderDTO

{
    private Long id;

    private AdministrativeUnitDTO superior;

    private OperationalUnitDTO subordinate ;
    
    private OrganizationDTO organization ;
}

