package com.uds.horbac.core.organizations.dto;

import java.util.Date;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {
	
	private Long id;
	
	@ApiModelProperty(name="The org's name", example="uds")
	@NotNull	    
	private String name;
	    
	private String description;
	
	/**
	 * Date of creation
	 */
	private Date inceptionDate;
	
	/**
	 * End of service dates
	 */
	private Date cessationDate;
	
	private OrganizationTypeDTO type;
}
