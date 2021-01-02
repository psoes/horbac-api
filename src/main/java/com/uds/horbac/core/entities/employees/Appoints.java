package com.uds.horbac.core.entities.employees;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.units.AdministrativeUnit;

import lombok.Data;

@Entity
@Data
public class Appoints

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /** Associations */
	@OneToOne
    private Employee employee;
	
	@OneToOne
	private AdministrativeUnit adminUnit;
	
	@OneToOne
	private Organization organization;
}

