
package com.uds.horbac.core.dto.emp_ownershipInfo;
import lombok.Data;

@Data
public class WheelDTO

{
  
    public Long id;
    /**
     * 
     */
    public String name;
    /**
     * 
     */
    public String type;
    /**
     * 
     */
    public String brand;

    private ManufacturerDTO manufacturer;
}

