
package com.uds.horbac.core.emp_ownershipInfo.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.entities.Location;
import com.uds.horbac.core.emp_personalInfo.entities.Person;

import lombok.Data;

@Data
@Entity
public class TitreFoncier

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
	@OneToOne
    private Location signaturePlace;
    /**
     * 
     */
	@ManyToOne
    private Person notary;
    /**
     * 
     */
	@ManyToOne
    private Person seller;
	
	private Date signatureDate;
	
	@OneToMany
	private List<Person> Witnesses;
	
}

