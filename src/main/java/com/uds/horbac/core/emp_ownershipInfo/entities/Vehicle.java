
package com.uds.horbac.core.emp_ownershipInfo.entities;
import java.awt.Color;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.emp_personalInfo.entities.Person;

import lombok.Data;

@Data
@Entity
public class Vehicle

{
    /** Attributes */
    /**
     * 
     */
	@Id
	private Long id;
	
    private String registrationCode;
    /**
     * 
     */
    private String brand;
    /**
     * 
     */
    @ManyToOne
    private VehiculeType type;
    /**
     * 
     */
    private Color color;
    /**
     * occasion ou boutique
     */
    private boolean origin;
    /**
     * 
     */
    private Double price;
    /**
     * 
     */
    private int numberOfRoues;
    /**
     * 
     */
    @ManyToOne
    private Manufacturer manufacturer;
    /**
     * 
     */
    @OneToMany
    private List<Repairer> repairers;
    /**
     * 
     */
    private Date PurchaseDate;
    /**
     * 
     */
    @OneToOne
    private Person driver;
    
    @ManyToOne
    private Carrosserie corrosserie;
    
    @ManyToOne
    private Wheel wheel;
}

