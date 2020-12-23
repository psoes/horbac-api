package com.uds.horbac.core.emp_ownershipInfo.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Device

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private String serialNumber;
    /**
     * 
     */
    @ManyToOne
    private Manufacturer manufacturer;
    /**
     * 
     */
    @ManyToOne
    private DeviceType type;
    /**
     * 
     */
    private String model;
    /**
     * 
     */
    @OneToMany
    private List<Repairer> repairers;
    /**
     * 
     */
    private Date purchaseDate;
    /**
     * 
     */
    private Double price;
}

