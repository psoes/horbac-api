package com.uds.horbac.core.entities.employees;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.units.OperationalUnit;

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

