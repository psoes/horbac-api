package com.uds.horbac.core.emp_ownershipInfo.dto;

import com.uds.horbac.core.emp_personalInfo.dto.PersonDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitreFoncierDTO {
	
	private Long id;

    private String signaturePlace;

    private PersonDTO notary;

    private PersonDTO seller;
}
