
package com.uds.horbac.core.dto.emp_famillyInfo;
import java.util.Date;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;
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
 
    private HOLocationDTO weddingPlace;

    private HOLocationDTO weddingChurch;

    private PersonDTO person;
}

