package com.uds.horbac.core.employees.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.organizations.entities.Organization;
import com.uds.horbac.core.unities.AdministrativeUnit;

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

