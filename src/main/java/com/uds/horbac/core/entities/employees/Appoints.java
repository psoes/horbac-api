package com.uds.horbac.core.entities.employees;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.units.AdministrativeUnit;

import lombok.Data;

@Entity
@Data
public class Appoints

{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(fetch =FetchType.EAGER)
    private Employee employee;
	
	@ManyToOne(fetch =FetchType.EAGER)
	private AdministrativeUnit adminUnit;
	
	@ManyToOne(fetch =FetchType.EAGER)
	private Organization organization;
}

