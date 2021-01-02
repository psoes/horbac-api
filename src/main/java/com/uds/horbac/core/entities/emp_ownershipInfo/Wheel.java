
package com.uds.horbac.core.entities.emp_ownershipInfo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Wheel

{
    /** Attributes */
    /**
     * 
     */
	@Id
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
   
    @ManyToOne
    private Manufacturer manufacturer;
}

