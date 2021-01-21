package com.uds.horbac.core.entities.units;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.organizations.Organization;

@Entity
public class Subordinate

{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
    private AdministrativeUnit subordinate;
	
	@ManyToOne
    private AdministrativeUnit superior;
	
	@ManyToOne
	private Organization organization;

	
	public Subordinate() {}
	
	public Subordinate(Long id, AdministrativeUnit subordinate, AdministrativeUnit superior, Organization organization) {
		super();
		this.id = id;
		this.subordinate = subordinate;
		this.superior = superior;
		this.organization = organization;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public AdministrativeUnit getSubordinate() {
		return subordinate;
	}

	public void setSubordinate(AdministrativeUnit subordinate) {
		this.subordinate = subordinate;
	}

	public AdministrativeUnit getSuperior() {
		return superior;
	}

	public void setSuperior(AdministrativeUnit superior) {
		this.superior = superior;
	}
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "Subordinate [id=" + id + ", subordinate=" + subordinate + ", superior=" + superior + "]";
	}
}

