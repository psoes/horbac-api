package com.uds.horbac.core.dto.emp_personalInfo;
import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class CountryDTO

{
    public Long id;
    /**
     * 
     */
    public String name;
 
    public HOLocationDTO location;
}

