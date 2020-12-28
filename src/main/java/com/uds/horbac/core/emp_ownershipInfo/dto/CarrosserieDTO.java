package com.uds.horbac.core.emp_ownershipInfo.dto;

import com.uds.horbac.core.emp_ownershipInfo.entities.Manufacturer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrosserieDTO {
	
	private String id;
   
    private String type;
   
    private String marque;
    
    private Manufacturer manufacturer;
}
