
package com.uds.horbac.core.dto.emp_healthInfo;
import java.util.List;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;
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
 
    private HOLocationDTO location;
  
    private Address address;
 
    private List<MedecinDTO> medecins;
 
}

