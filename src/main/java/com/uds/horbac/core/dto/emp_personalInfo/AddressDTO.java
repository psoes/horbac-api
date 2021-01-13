package com.uds.horbac.core.dto.emp_personalInfo;
import lombok.Data;

@Data
public class AddressDTO

{
    private Long id;
	
    private String city;
   
    private String postalCode;
    
    private String street;
    
    private String state;
    
    private String region;
  
    private String continent;
    
}

