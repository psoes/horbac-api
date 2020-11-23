package com.uds.horbac.core.permissions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Action;
import com.uds.horbac.core.employees.Emitter;
import com.uds.horbac.core.resources.Resource;

import lombok.Data;

@Data
@Entity
public class CanSuggest

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /** Associations */
	
	@ManyToOne
    private Action action;
	
	@ManyToOne
	private Emitter emitter;
	
	@ManyToOne
	private Resource resource;

}

