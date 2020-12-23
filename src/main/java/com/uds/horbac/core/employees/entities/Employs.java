package com.uds.horbac.core.employees.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.organizations.entities.Organization;
import com.uds.horbac.core.unities.OperationalUnit;

import lombok.Data;

@Data
@Entity
public class Employs

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /** Associations */
	@ManyToOne
    private Employee employee;
    
	@ManyToOne
    private OperationalUnit operationalUnit;
	
	@ManyToOne
	private Organization organization;
}

