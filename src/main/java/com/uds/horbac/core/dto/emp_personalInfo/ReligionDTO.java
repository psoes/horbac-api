
package com.uds.horbac.core.dto.emp_personalInfo;
import java.util.Date;

import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class ReligionDTO

{
  
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private Date startDate;
    
    private LocationDTO location;
  
}

