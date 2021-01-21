package com.uds.horbac.core.entities.emp_personalInfo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Address

{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
    private String city;
   
    private String postalCode;
    
    private String street;
    
    private String state;
    
    private String region;
  
    private String continent;
    
    private ContactType type;
    
}

