package com.uds.horbac.core.unities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("ADMINISTRATIVE")
public class AdministrativeUnit extends OrgUnit {
	public AdministrativeUnit() {
		super();
	}
}

