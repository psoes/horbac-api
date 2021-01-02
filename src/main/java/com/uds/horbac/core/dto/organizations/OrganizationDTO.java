package com.uds.horbac.core.dto.organizations;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import com.uds.horbac.core.dto.contexts.LocationDTO;

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
	@NotNull(message="The name should not be null")
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
	
	@URL
	private String url;
    
    private LocationDTO location;
    
    private SocialReasonDTO socialReason;
}
