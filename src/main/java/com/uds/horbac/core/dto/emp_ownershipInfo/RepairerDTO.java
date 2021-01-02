
package com.uds.horbac.core.dto.emp_ownershipInfo;
import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RepairerDTO extends PersonDTO

{
  
    private RepairerSpecialityDTO speciality;
}

