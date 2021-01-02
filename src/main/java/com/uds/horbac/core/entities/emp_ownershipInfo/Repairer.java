
package com.uds.horbac.core.entities.emp_ownershipInfo;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.emp_personalInfo.Person;

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

