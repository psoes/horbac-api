package com.uds.horbac.core.entities.permissions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.activities.Activity;
import com.uds.horbac.core.entities.contexts.Context;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.resources.Vue;
import com.uds.horbac.core.entities.units.AdministrativeUnit;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
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

