package com.uds.horbac.core.emp_ownershipInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class BankAccount

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private String code;
    /**
     * 
     */
	@ManyToOne
    private BankAccountProvider provider;
}

