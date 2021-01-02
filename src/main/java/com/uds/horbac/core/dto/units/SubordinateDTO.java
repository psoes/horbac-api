package com.uds.horbac.core.dto.units;

import lombok.Data;

@Data
public class SubordinateDTO

{

    private Long id;

    private AdministrativeUnitDTO subordinate;
	

    private AdministrativeUnitDTO superior;
}

