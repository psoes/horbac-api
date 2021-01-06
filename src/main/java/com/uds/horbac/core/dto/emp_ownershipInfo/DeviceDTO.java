package com.uds.horbac.core.dto.emp_ownershipInfo;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class DeviceDTO

{
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private String serialNumber;

    private ManufacturerDTO manufacturer;
  
    private DeviceTypeDTO type;
    /**
     * 
     */
    private String model;

    private List<RepairerDTO> repairers;
    /**
     * 
     */
    private Date purchaseDate;
    /**
     * 
     */
    private Double price;
}

