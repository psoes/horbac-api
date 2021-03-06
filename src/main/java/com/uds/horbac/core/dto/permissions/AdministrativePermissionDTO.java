package com.uds.horbac.core.dto.permissions;

import com.uds.horbac.core.dto.activities.ActivityDTO;
import com.uds.horbac.core.dto.contexts.ContextDTO;
import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.dto.resources.VueDTO;
import com.uds.horbac.core.dto.units.AdministrativeUnitDTO;
import com.uds.horbac.core.dto.units.OperationalUnitDTO;
import com.uds.horbac.core.entities.permissions.TreatmentMode;

import lombok.Data;

@Data
public class AdministrativePermissionDTO

{
    private Long id;

    private String name;

    private ActivityDTO activity;
 
    private ContextDTO context;

    private VueDTO vue;

    private AdministrativeUnitDTO administrativeUnit;
    
    private OperationalUnitDTO operationalUnit;    

    private OrganizationDTO organisation; 
    
    private TreatmentMode mode;
}

