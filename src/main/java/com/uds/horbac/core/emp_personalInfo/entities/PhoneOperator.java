
package com.uds.horbac.core.emp_personalInfo.entities;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PhoneOperator

{
    /** Attributes */
    /**
     * 
     */
	@Id
    public String code;
    /**
     * 
     */
    public String name;
}

