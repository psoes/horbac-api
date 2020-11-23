package com.uds.horbac.core.resources;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Uses

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /** Associations */
	
	@ManyToOne
    private Resource resource;
	
	@ManyToOne
    private Vue vue;
	
	
}

