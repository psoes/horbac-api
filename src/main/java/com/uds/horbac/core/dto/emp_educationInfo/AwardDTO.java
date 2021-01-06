package com.uds.horbac.core.dto.emp_educationInfo;
import java.util.Date;

import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class AwardDTO

{
  
    public Long id;
    /**
     * 
     */
    public String description;
    /**
     * 
     */
    public Date date;

    public LocationDTO location;
}

