
package com.uds.horbac.core.dto.emp_healthInfo;
import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class PharmacyDTO

{

    public Long id;
    /**
     * 
     */
    public String name;

    public LocationDTO location;
}

