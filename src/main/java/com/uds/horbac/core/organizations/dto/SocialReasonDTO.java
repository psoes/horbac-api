package com.uds.horbac.core.organizations.dto;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class SocialReasonDTO {
	
	private Long id;
	
	@NotNull
	private String name;
	
	private String description;

}
