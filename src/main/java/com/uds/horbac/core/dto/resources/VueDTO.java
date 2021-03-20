package com.uds.horbac.core.dto.resources;

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
	
	private String desription;
   
    private String domain;    
}

