
package com.uds.horbac.core.emp_ownershipInfo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
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

