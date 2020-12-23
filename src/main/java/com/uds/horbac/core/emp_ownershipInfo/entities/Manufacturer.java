
package com.uds.horbac.core.emp_ownershipInfo.entities;
import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.Location;

import lombok.Data;

@Data
@Entity
public class Manufacturer

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
    private URL website;
    /**
     * 
     */
    private String logo;
}

