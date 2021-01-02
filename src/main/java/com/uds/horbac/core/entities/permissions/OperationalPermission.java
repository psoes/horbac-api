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
import com.uds.horbac.core.entities.units.OperationalUnit;

import lombok.Data;

@Data
@Entity
public class OperationalPermission

{
    /** Attributes */
    /**
     * 
     */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    /** Associations */
	@ManyToOne
    private Activity activity;
	
	@ManyToOne
    private Vue vue;
	
	@ManyToOne
    private Context context;
	
	@ManyToOne
    private OperationalUnit unit;
	
	@ManyToOne
	private Organization organization;
	
	private TreatmentMode mode;
	
}

