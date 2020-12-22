package com.uds.horbac.core.organizations.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class OrganizationType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@NotNull
    private String name;
    
    private String description;

}
