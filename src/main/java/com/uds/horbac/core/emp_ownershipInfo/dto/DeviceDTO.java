package com.uds.horbac.core.emp_ownershipInfo.dto;

import java.util.Date;
import java.util.List;

import com.uds.horbac.core.emp_ownershipInfo.entities.DeviceType;
import com.uds.horbac.core.emp_ownershipInfo.entities.Manufacturer;
import com.uds.horbac.core.emp_ownershipInfo.entities.Repairer;

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

    private Manufacturer manufacturer;

    private DeviceType type;
    
    private String model;

    private List<Repairer> repairers;

    private Date purchaseDate;

    private Double price;
	
}
