
package com.uds.horbac.core.emp_healthInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.Location;

import lombok.Data;

@Data
@Entity
public class Pharmacy

{
    /** Attributes */
    /**
     * 
     */
	@Id
    public Long id;
    /**
     * 
     */
    public String name;
    /**
     * 
     */
    @OneToOne
    public Location location;
}

