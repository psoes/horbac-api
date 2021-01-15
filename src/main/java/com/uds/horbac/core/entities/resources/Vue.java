package com.uds.horbac.core.entities.resources;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;

import lombok.Data;

/**
 * 
 * @author fidele
 * 
 * here Vue represents a domain in which we have resources
 *
 */
@Data
@Entity
public class Vue

{
    /** Attributes */
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private String name;
    
    private String ipAddress;
    
    /**
     * extension can be .org, .edu
     */
    private String exention;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private HOLocation location;
    
    
}

