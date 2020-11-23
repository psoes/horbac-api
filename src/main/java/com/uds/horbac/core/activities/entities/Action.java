package com.uds.horbac.core.activities.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Action

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
	
	private String name;
}

