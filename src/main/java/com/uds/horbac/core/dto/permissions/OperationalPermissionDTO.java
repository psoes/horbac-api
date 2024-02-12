package com.uds.horbac.core.dto.permissions;

import com.uds.horbac.core.dto.activities.ActivityDTO;
import com.uds.horbac.core.dto.contexts.ContextDTO;
import com.uds.horbac.core.dto.organizations.OrganizationDTO;
import com.uds.horbac.core.dto.resources.VueDTO;
import com.uds.horbac.core.dto.units.OperationalUnitDTO;
import com.uds.horbac.core.entities.permissions.TreatmentMode;

import lombok.Data;

@Data
public class OperationalPermissionDTO

{
    
    private Long id;
    private String name;
    private ActivityDTO activity;	
    private VueDTO vue;	
    private ContextDTO context;
    private OperationalUnitDTO unit;
	private OrganizationDTO organization;	
	private TreatmentMode mode;

    private Boolean requiredApproval;

    private Integer approvalLevel;

    private Integer priority;

    private Integer timeout;

    private long duration;
    private String decision;
	
}

