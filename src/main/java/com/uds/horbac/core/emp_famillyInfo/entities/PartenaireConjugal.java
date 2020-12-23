
package com.uds.horbac.core.emp_famillyInfo.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.Location;
import com.uds.horbac.core.emp_personalInfo.entities.Person;

import lombok.Data;

@Data
@Entity
public class PartenaireConjugal

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private Long id;
    /**
     * 
     */
    private Date weddingDate;
    /**
     * 
     */
    @OneToOne
    private Location weddingPlace;
    /**
     * 
     */
    @OneToOne
    private Location weddingChurch;
    /**
     * 
     */
    @OneToOne
    private Person person;
}

