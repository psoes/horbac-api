package com.uds.horbac.core.permissions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Activity;
import com.uds.horbac.core.contexts.Context;

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
}

