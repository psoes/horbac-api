
package com.uds.horbac.core.entities.emp_passionInfo;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SewingStyle

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
    public String description;
}

