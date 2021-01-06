
package com.uds.horbac.core.entities.emp_healthInfo;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.emp_personalInfo.Address;

import lombok.Data;

@Data
@Entity
public class Hospital

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
    private String name;
    /**
     * 
     */
    @OneToOne
    private HOLocation location;
    /**
     * 
     */
    @OneToOne
    private Address address;
    /**
     * 
     */
    @OneToMany
    private List<Medecin> medecins;
 
}

