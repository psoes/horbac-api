package com.uds.horbac.core.emp_ownershipInfo.dto;

import java.awt.Color;
import java.util.Date;
import java.util.List;

import com.uds.horbac.core.emp_ownershipInfo.entities.Carrosserie;
import com.uds.horbac.core.emp_ownershipInfo.entities.Manufacturer;
import com.uds.horbac.core.emp_ownershipInfo.entities.Repairer;
import com.uds.horbac.core.emp_ownershipInfo.entities.VehiculeType;
import com.uds.horbac.core.emp_ownershipInfo.entities.Wheel;
import com.uds.horbac.core.emp_personalInfo.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeDTO {
	
	private Long id;
	
    private String registrationCode;
   
    private String brand;
  
    private VehiculeType type;

    private Color color;
    
    private boolean origin;
   
    private Double price;
 
    private int numberOfRoues;
  
    private Manufacturer manufacturer;
   
    private List<Repairer> repairers;
   
    private Date PurchaseDate;

    private Person driver;
    
    private Carrosserie corrosserie;
    
    private Wheel wheel;
}
