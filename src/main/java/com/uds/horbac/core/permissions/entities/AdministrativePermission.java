package com.uds.horbac.core.permissions.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Activity;
import com.uds.horbac.core.contexts.Context;
import com.uds.horbac.core.organizations.entities.Organization;
import com.uds.horbac.core.resources.Vue;
import com.uds.horbac.core.units.AdministrativeUnit;

import lombok.Data;

@Data
@Entity
public class AdministrativePermission

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /**
     * 
     */
    private String name;
    /** Associations */
    
    @ManyToOne
    private Activity activity;
    
    @ManyToOne
    private Context context;
    
    @ManyToOne
    private Vue view;
    
    @ManyToOne
    private AdministrativeUnit administrativeUnit;
    
    @ManyToOne
    private Organization organisation; 
    
    private TreatmentMode mode;
}

