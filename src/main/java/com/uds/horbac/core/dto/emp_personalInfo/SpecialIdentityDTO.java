
package com.uds.horbac.core.dto.emp_personalInfo;
import lombok.Data;

@Data
public class SpecialIdentityDTO

{
	private Long id;
	
    private String nationalID;
  
    private String passportID;
  
    private String drivingLicense;

    private String socialSecurityCode;
}

