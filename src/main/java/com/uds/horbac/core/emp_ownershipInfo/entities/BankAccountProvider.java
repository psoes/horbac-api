package com.uds.horbac.core.emp_ownershipInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.entities.Location;
import com.uds.horbac.core.emp_personalInfo.entities.Address;

import lombok.Data;

@Data
@Entity
public class BankAccountProvider

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
    private Address address;
    /**
     * 
     */
    @OneToOne
    private Location location;
  
}

