
package com.uds.horbac.core.dto.emp_healthInfo;
import com.uds.horbac.core.dto.contexts.HOLocationDTO;

import lombok.Data;

@Data
public class PharmacyDTO

{

    public Long id;
    /**
     * 
     */
    public String name;

    public HOLocationDTO location;
}

