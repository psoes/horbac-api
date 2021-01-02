
package com.uds.horbac.core.dto.emp_ownershipInfo;
import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class ManufacturerDTO

{
 
    private Long id;
    /**
     * 
     */
    private String name;

    private LocationDTO location;
    /**
     * 
     */
    private String website;
    /**
     * 
     */
    private String logo;
}

