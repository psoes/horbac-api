package com.uds.horbac.core.dto.organizations;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;
import com.uds.horbac.core.dto.emp_personalInfo.AddressDTO;

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
    
    private HOLocationDTO location;
    
    private SocialReasonDTO socialReason;
    
    private AddressDTO address;
    
    private String logo;
}
