package com.uds.horbac.core.entities.units;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.organizations.Organization;

@Entity
public class PlaceUnder

{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
    private AdministrativeUnit superior;
    
	@ManyToOne
    private OperationalUnit subordinate ;
	
	@ManyToOne
	private Organization organization;

	public PlaceUnder() {}

	public PlaceUnder(Long id, AdministrativeUnit superior, OperationalUnit subordinate, Organization org) {
		super();
		this.id = id;
		this.superior = superior;
		this.subordinate = subordinate;
		this.organization = org;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AdministrativeUnit getSuperior() {
		return superior;
	}

	public void setSuperior(AdministrativeUnit superior) {
		this.superior = superior;
	}

	public OperationalUnit getSubordinate() {
		return subordinate;
	}

	public void setSubordinate(OperationalUnit subordinate) {
		this.subordinate = subordinate;
	}

	@Override
	public String toString() {
		return "PlaceUnder [id=" + id + ", superior=" + superior + ", subordinate=" + subordinate + "]";
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
	
}

