package com.uds.horbac.core.entities.units;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("ADMINISTRATIVE")
@Data
public class AdministrativeUnit extends OrgUnit implements Serializable
{
	public AdministrativeUnit() {
		super();
	}
}

