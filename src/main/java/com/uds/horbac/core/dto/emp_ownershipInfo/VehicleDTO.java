
package com.uds.horbac.core.dto.emp_ownershipInfo;
import java.awt.Color;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;

import lombok.Data;

@Data
public class VehicleDTO

{
	private Long id;
	
    private String registrationCode;
    /**
     * 
     */
    private String brand;

    private VehiculeTypeDTO type;
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
    private ManufacturerDTO manufacturer;
    /**
     * 
     */
    @OneToMany
    private List<RepairerDTO> repairers;
    /**
     * 
     */
    private Date PurchaseDate;
    /**
     * 
     */
    @OneToOne
    private PersonDTO driver;
    
    @ManyToOne
    private CarrosserieDTO corrosserie;
    
    @ManyToOne
    private WheelDTO wheel;
}

