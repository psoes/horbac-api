package com.uds.horbac.core.dto.resources;

import lombok.Data;

@Data
public class ScopeDTO {
	
	private Long id;
	
	/**
	 * the name of the scope like read, write
	 */
	private String name;
	
	private String description;

}
