package com.uds.horbac.core.entities.organizations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class OrganizationType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@NotBlank(message="The Type should not be blank")
    private String name;
    
    private String description;

}
