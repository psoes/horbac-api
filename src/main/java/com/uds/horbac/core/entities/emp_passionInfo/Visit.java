
package com.uds.horbac.core.entities.emp_passionInfo;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.uds.horbac.core.entities.contexts.HOLocation;

import lombok.Data;

@Data
@Entity
public class Visit

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private long id;
    /**
     * 
     */
    private Date startDate;
    /**
     * 
     */
    private Date endDate;
    /**
     * 
     */
    @OneToMany
    private List<HOLocation> places;
}

