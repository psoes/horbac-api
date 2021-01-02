package com.uds.horbac.core.entities.emp_workInfo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.emp_personalInfo.Address;
import com.uds.horbac.core.entities.emp_personalInfo.Person;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
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
    private HOLocation location;
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

