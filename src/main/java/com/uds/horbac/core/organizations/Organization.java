package com.uds.horbac.core.organizations;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Organization

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    
    private String name;
}

