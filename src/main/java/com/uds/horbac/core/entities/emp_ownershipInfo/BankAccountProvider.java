package com.uds.horbac.core.entities.emp_ownershipInfo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.emp_personalInfo.Address;

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
    private HOLocation location;
  
}

