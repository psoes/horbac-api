package com.uds.horbac.core.entities.units;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.organizations.Organization;

import lombok.Data;

@Entity
@Data
public class Subordinate

{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    private AdministrativeUnit subordinate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    private AdministrativeUnit superior;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Organization organization;

	@Override
	public String toString() {
		return "Subordinate [id=" + id +", org: "+organization+ ", subordinate=" + subordinate + ", superior=" + superior + "]";
	}
}

