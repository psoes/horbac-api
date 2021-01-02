package com.uds.horbac.core.dto.emp_ownershipInfo;
import java.util.Date;

import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class BiensImmobiliersDTO

{
 
    public Long id;
    /**
     * 
     */
    public String name;

    public LocationDTO location;
    /**
     * 
     */
    public Date dateObtention;
}

