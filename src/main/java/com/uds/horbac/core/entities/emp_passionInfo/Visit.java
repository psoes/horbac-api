
package com.uds.horbac.core.entities.emp_passionInfo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.contexts.HOLocation;

import lombok.Data;

@Data
@Entity
public class Visit

{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date startDate; 
    private Date endDate;
    @OneToOne
    private HOLocation place;
    
    /**
     * the order of the visit 1er, 2, 3
     */
    private int order;
    
}

