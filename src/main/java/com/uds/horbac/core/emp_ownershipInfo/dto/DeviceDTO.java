package com.uds.horbac.core.emp_ownershipInfo.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {
	
	private Long id;
	
    private String name;

    private String serialNumber;

    private ManufacturerDTO manufacturer;

    private DeviceTypeDTO type;
    
    private String model;

    private List<RepairerDTO> repairers;

    private Date purchaseDate;

    private Double price;
	
}
