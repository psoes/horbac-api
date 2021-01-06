
package com.uds.horbac.core.dto.emp_healthInfo;
import java.util.List;

import com.uds.horbac.core.dto.contexts.LocationDTO;
import com.uds.horbac.core.entities.emp_personalInfo.Address;

import lombok.Data;

@Data
public class HospitalDTO

{

    private Long id;
    /**
     * 
     */
    private String name;
 
    private LocationDTO location;
  
    private Address address;
 
    private List<MedecinDTO> medecins;
 
}

