
package com.uds.horbac.core.dto.emp_famillyInfo;
import java.util.Date;

import com.uds.horbac.core.dto.contexts.LocationDTO;
import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;

import lombok.Data;

@Data
public class PartenaireConjugalDTO

{
    private Long id;
    /**
     * 
     */
    private Date weddingDate;
 
    private LocationDTO weddingPlace;

    private LocationDTO weddingChurch;

    private PersonDTO person;
}

