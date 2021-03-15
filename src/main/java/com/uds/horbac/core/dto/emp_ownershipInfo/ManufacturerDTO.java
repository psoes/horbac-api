
package com.uds.horbac.core.dto.emp_ownershipInfo;
import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class ManufacturerDTO

{
 
    private Long id;
    /**
     * 
     */
    private String name;

    private HOLocationDTO location;
    /**
     * 
     */
    private String website;
    /**
     * 
     */
    private String logo;
}

