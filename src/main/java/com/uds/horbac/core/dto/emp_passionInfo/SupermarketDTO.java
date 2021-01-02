
package com.uds.horbac.core.dto.emp_passionInfo;
import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class SupermarketDTO

{
    
    public Long id;
    /**
     * 
     */
    public String name;
 
    public LocationDTO location;

}

