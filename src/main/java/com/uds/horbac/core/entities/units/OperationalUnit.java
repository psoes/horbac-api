package com.uds.horbac.core.entities.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("OPERATIONAL")
@EqualsAndHashCode(callSuper=false)
public class OperationalUnit extends OrgUnit{
	public OperationalUnit() {
		super();
	}
}

