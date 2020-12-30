package com.uds.horbac.core.emp_ownershipInfo.dto;

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
    
    private ManufacturerDTO manufacturer;
}
