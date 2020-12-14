package com.uds.horbac.core.employees;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.organizations.entities.Organization;
import com.uds.horbac.core.unities.AministrativeUnit;

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
	private AministrativeUnit adminUnit;
	
	@OneToOne
	private Organization organization;
}

