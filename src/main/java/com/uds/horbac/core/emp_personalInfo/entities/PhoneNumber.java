
package com.uds.horbac.core.emp_personalInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class PhoneNumber

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private String phone;
    /**
     * 
     */
	@ManyToOne
	private PhoneOperator operator;
	
    private ContactType type;
}

