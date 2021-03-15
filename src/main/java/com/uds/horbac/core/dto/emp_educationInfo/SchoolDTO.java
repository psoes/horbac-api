
package com.uds.horbac.core.dto.emp_educationInfo;
import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class SchoolDTO

{
 
    public Long id;
    /**
     * 
     */
    public String name;

    public HOLocationDTO location;
}

