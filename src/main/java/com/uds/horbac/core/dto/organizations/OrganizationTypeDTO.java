package com.uds.horbac.core.dto.organizations;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class OrganizationTypeDTO {
	
	 private Long id;
	 
	 @NotNull  
	 private String name;
	    
	 private String description;

}
