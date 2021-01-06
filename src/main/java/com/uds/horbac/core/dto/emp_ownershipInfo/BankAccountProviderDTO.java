package com.uds.horbac.core.dto.emp_ownershipInfo;
import com.uds.horbac.core.dto.contexts.LocationDTO;
import com.uds.horbac.core.dto.emp_personalInfo.AddressDTO;

import lombok.Data;

@Data
public class BankAccountProviderDTO

{
  
    private Long id;
    /**
     * 
     */
    private String name;

    private AddressDTO address;
  
    private LocationDTO location;
  
}

