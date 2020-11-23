package com.uds.horbac.core.contexts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.activities.entities.Action;
import com.uds.horbac.core.employees.WorkEmployee;
import com.uds.horbac.core.resources.Resource;

import lombok.Data;

@Entity
@Data
public class Define

{
    /** Attributes */
    /**
     * 
     */
	@Id
    public Long id;
    /** Associations */
	
	@ManyToOne
    private WorkEmployee employee;

	@ManyToOne
    private Context context;
	
	@ManyToOne
    private Action action;
	
	@ManyToOne
	private Resource resource;
}

