
package com.uds.horbac.core.entities.emp_personalInfo;
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

