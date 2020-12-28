package com.uds.horbac.core.emp_ownershipInfo.dto;

import com.uds.horbac.core.emp_ownershipInfo.entities.Manufacturer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WheelDTO {
	
	public Long id;
 
    public String name;

    public String type;

    public String brand;
   
    private Manufacturer manufacturer;
}
