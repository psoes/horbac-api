
package com.uds.horbac.core.entities.emp_personalInfo;
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

