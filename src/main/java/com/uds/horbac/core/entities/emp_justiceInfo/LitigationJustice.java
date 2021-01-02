
package com.uds.horbac.core.entities.emp_justiceInfo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;

import lombok.Data;

@Data
@Entity
public class LitigationJustice

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
    private String description;
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
    @OneToOne
    private HOLocation location;
}

