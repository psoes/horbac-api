package com.uds.horbac.core.entities.emp_personalInfo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Address

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /**
     * 
     */
	@ManyToOne
    private City city;
    /**
     * 
     */
    private String postalCode;
    
    private String street;
    
    private String state;
    
}

