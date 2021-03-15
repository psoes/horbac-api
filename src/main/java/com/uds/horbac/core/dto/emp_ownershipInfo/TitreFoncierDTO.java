
package com.uds.horbac.core.dto.emp_ownershipInfo;
import java.util.Date;
import java.util.List;

import com.uds.horbac.core.dto.contexts.HOLocationDTO;
import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;

import lombok.Data;

@Data
public class TitreFoncierDTO

{
 
    private Long id;
  
    private HOLocationDTO signaturePlace;

    private PersonDTO notary;

    private PersonDTO seller;
	
	private Date signatureDate;

	private List<PersonDTO> Witnesses;
	
}

