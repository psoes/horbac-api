package com.uds.horbac.core.dto.resources;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

/**
 * 
 * @author fidele
 * 
 * here Vue represents a domain in which we have resources
 *
 */
@Data
public class VueDTO

{ 
    private Long id;
  
    private String name;
    
    private String ipAddress;
    
    /**
     * extension can be .org, .edu
     */
    private String exention;

    private HOLocationDTO location;
    
    
    
    
}

