package com.uds.horbac.core.emp_workInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.entities.Location;
import com.uds.horbac.core.emp_personalInfo.entities.Address;
import com.uds.horbac.core.emp_personalInfo.entities.Person;

import lombok.Data;

@Data
@Entity
public class Company

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
    @OneToOne
    private Person employer;
    /**
     * 
     */
    @OneToOne
    private Location location;
    /**
     * 
     */
    @OneToOne
    private Address address;
    /**
     * 
     */
    private String registrationCode;
}

