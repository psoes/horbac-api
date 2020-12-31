package com.uds.horbac.core.emp_ownershipInfo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Carrosserie

{
    /** Attributes */
    /**
     * 
     */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    /**
     * 
     */
    private String type;
    /**
     * 
     */
    private String marque;
    
    @ManyToOne
    private Manufacturer manufacturer;
}

