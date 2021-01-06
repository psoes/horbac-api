
package com.uds.horbac.core.entities.emp_personalInfo;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SpecialIdentity

{
    /** Attributes */
    /**
     * 
     */
	@Id
    private String nationalID;
    /**
     * 
     */
    private String passportID;
    /**
     * 
     */
    private String drivingLicense;
    /**
     * 
     */
    private String socialSecurityCode;
}

