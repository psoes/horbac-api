package com.uds.horbac.core.emp_ownershipInfo.dto;

import java.awt.Color;
import java.util.Date;
import java.util.List;

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
  
    private VehiculeTypeDTO type;

    private Color color;
    
    private boolean origin;
   
    private Double price;
 
    private int numberOfRoues;
  
    private ManufacturerDTO manufacturer;
   
    private List<RepairerDTO> repairers;
   
    private Date PurchaseDate;

    private Person driver;
    
    private CarrosserieDTO corrosserie;
    
    private WheelDTO wheel;
}
