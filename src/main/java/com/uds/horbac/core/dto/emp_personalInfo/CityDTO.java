package com.uds.horbac.core.dto.emp_personalInfo;
import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class CityDTO

{
 
    private Long id;
    /**
     * 
     */
    private String name;
  
    private HOLocationDTO location;
  
    private CountryDTO country;
}

