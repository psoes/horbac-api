package com.uds.horbac.core.permissions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Action;
import com.uds.horbac.core.employees.Approver;
import com.uds.horbac.core.resources.Resource;

import lombok.Data;

@Data
@Entity
public class CanTreat

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
	private Approver approver;
	
	@ManyToOne
	private Resource resource;

}

