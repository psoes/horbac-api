package com.uds.horbac.core.dto.emp_ownershipInfo;
import java.util.Date;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class BiensImmobiliersDTO

{
 
    public Long id;
    /**
     * 
     */
    public String name;

    public HOLocationDTO location;
    /**
     * 
     */
    public Date dateObtention;
}

