package com.uds.horbac.core.dto.emp_ownershipInfo;
import lombok.Data;

@Data
public class CarrosserieDTO

{
    private String id;
    /**
     * 
     */
    private String type;
    /**
     * 
     */
    private String marque;

    private ManufacturerDTO manufacturer;
}

