
package com.uds.horbac.core.emp_ownershipInfo.entities;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.emp_personalInfo.entities.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("REPAIRER")
public class Repairer extends Person

{
    /** Attributes */
    /**
     * 
     */
	@ManyToOne
    private RepairerSpeciality speciality;
}

