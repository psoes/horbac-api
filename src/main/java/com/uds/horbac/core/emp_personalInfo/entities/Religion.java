
package com.uds.horbac.core.emp_personalInfo.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.contexts.entities.Location;

import lombok.Data;

@Data
@Entity
public class Religion

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
    private Date startDate;
    /**
     * 
     */
    @OneToOne
    private Location location;
  
}
