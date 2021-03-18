package com.uds.horbac.core.entities.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private String Desription;

    private String domain;
    
    
}

