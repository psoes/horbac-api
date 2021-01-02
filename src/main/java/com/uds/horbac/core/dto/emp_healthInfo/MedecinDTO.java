
package com.uds.horbac.core.dto.emp_healthInfo;
import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MedecinDTO extends PersonDTO

{
 
    private MedecinSpecialityDTO speciality;
}

