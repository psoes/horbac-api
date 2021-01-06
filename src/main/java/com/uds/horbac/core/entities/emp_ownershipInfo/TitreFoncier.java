
package com.uds.horbac.core.entities.emp_ownershipInfo;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.emp_personalInfo.Person;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    /**
     * 
     */
	@OneToOne
    private HOLocation signaturePlace;
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

