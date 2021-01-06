package com.uds.horbac.core.dto.units;

import lombok.Data;

@Data
public class PlaceUnderDTO

{
    private Long id;

    private AdministrativeUnitDTO superior;

    private OperationalUnitDTO subordinate ;
}

