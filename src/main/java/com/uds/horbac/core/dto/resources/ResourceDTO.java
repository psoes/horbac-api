package com.uds.horbac.core.dto.resources;


import java.util.List;

import lombok.Data;

/**
 * 
 * @author fidele
 * a resource here represents a resource server in oauth 2.0 meaning
 */
@Data
public class ResourceDTO
{
	private Long id;
	
	private String name;
	
	private String description;
	
	private String url;
	
	private List<ScopeDTO> scopes;  
    
}

