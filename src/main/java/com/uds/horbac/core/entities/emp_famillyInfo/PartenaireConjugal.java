
package com.uds.horbac.core.entities.emp_famillyInfo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.emp_personalInfo.Person;

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
    private HOLocation weddingPlace;
    /**
     * 
     */
    @OneToOne
    private HOLocation weddingChurch;
    /**
     * 
     */
    @OneToOne
    private Person person;
}

