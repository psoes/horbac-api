
package com.uds.horbac.core.dto.emp_passionInfo;
import java.util.List;

import com.uds.horbac.core.dto.contexts.LocationDTO;

import lombok.Data;

@Data
public class SewingSalonDTO

{
   
    public Long id;
    /**
     * 
     */
    public String name;
 
    public LocationDTO location;

   
    private List<SewingStyleDTO> styles;
}

