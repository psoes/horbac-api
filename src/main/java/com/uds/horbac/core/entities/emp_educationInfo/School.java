
package com.uds.horbac.core.entities.emp_educationInfo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;

import lombok.Data;

@Data
@Entity
public class School

{
    /** Attributes */
    /**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    /**
     * 
     */
    public String name;
    /**
     * 
     */
    @OneToOne
    public HOLocation location;
}

