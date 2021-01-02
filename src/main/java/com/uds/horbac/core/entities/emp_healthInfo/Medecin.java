
package com.uds.horbac.core.entities.emp_healthInfo;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.emp_personalInfo.Person;

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

