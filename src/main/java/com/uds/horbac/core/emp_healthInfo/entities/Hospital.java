
package com.uds.horbac.core.emp_healthInfo.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.entities.Location;
import com.uds.horbac.core.emp_personalInfo.entities.Address;

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
    private Long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    @OneToOne
    private Location location;
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

