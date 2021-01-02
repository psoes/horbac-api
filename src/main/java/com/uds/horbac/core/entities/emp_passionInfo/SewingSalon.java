
package com.uds.horbac.core.entities.emp_passionInfo;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;

import lombok.Data;

@Data
@Entity
public class SewingSalon

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
    public HOLocation location;
    /**
     * 
     */
    @OneToMany
    private List<SewingStyle> styles;
}

