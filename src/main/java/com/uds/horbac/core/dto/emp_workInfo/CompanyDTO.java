package com.uds.horbac.core.dto.emp_workInfo;
import com.uds.horbac.core.dto.contexts.LocationDTO;
import com.uds.horbac.core.dto.emp_personalInfo.AddressDTO;
import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;

import lombok.Data;

@Data
public class CompanyDTO

{
    private Long id;

    private String name;
   
    private PersonDTO employer;
    
    private LocationDTO location;
    
    private AddressDTO address;
    
    private String registrationCode;
}

