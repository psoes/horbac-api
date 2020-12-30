package com.uds.horbac.core.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.entities.Location;

import inet.ipaddr.IPAddress;
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
    
    private IPAddress ipAddress;
    
    /**
     * extension can be .org, .edu
     */
    private String exention;
    
    @OneToOne
    private Location location;
    
    
    
    
}

