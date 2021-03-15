
package com.uds.horbac.core.dto.emp_passionInfo;
import java.util.List;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class SewingSalonDTO

{
   
    public Long id;
    /**
     * 
     */
    public String name;
 
    public HOLocationDTO location;

   
    private List<SewingStyleDTO> styles;
}

