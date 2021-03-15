
package com.uds.horbac.core.dto.emp_passionInfo;
import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class SupermarketDTO

{
    
    public Long id;
    /**
     * 
     */
    public String name;
 
    public HOLocationDTO location;

}

