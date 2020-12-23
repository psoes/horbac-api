
package com.uds.horbac.core.emp_healthInfo.entities;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.emp_personalInfo.entities.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("MEDECIN")
public class Medecin extends Person

{
    /** Attributes */
    /**
     * 
     */
	@ManyToOne
    private MedecinSpeciality speciality;
}

