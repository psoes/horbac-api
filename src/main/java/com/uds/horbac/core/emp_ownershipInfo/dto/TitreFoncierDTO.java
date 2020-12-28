package com.uds.horbac.core.emp_ownershipInfo.dto;

import com.uds.horbac.core.emp_personalInfo.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitreFoncierDTO {
	
	private Long id;

    private String signaturePlace;

    private Person notary;

    private Person seller;
}
