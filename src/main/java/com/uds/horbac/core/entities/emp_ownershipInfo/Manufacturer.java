
package com.uds.horbac.core.entities.emp_ownershipInfo;
import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;

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
    private HOLocation location;
    /**
     * 
     */
    private URL website;
    /**
     * 
     */
    private String logo;
}

