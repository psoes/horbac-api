package com.uds.horbac.core.permissions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Activity;
import com.uds.horbac.core.contexts.Context;
import com.uds.horbac.core.resources.Vue;
import com.uds.horbac.core.units.OperationalUnit;

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
	
}

