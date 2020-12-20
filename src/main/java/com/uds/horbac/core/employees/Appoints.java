package com.uds.horbac.core.employees;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.organizations.entities.Organization;
import com.uds.horbac.core.units.AdministrativeUnit;

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
    private WorkEmployee employee;
	
	@OneToOne
	private AdministrativeUnit adminUnit;
	
	@OneToOne
	private Organization organization;
}

