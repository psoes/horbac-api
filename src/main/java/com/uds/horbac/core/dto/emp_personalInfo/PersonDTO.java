
package com.uds.horbac.core.dto.emp_personalInfo;
import java.util.Date;
import java.util.List;

import com.uds.horbac.core.dto.emp_famillyInfo.PartenaireConjugalDTO;
import com.uds.horbac.core.entities.emp_famillyInfo.MaritalStatus;
import com.uds.horbac.core.entities.emp_personalInfo.Gender;
import com.uds.horbac.core.entities.emp_personalInfo.Regime;
import com.uds.horbac.core.entities.emp_personalInfo.Title;

import lombok.Data;

@Data
public class PersonDTO

{

    private Long id;
    /**
     * 
     */
    private String firstName;
    /**
     * 
     */
    private String lastName;
    /**
     * 
     */
    private String middleName;
    /**
     * 
     */
    private String pseudo;
    /**
     * 
     */
    private Date birthDate;
    /**
     * 
     */
    private Gender sex;

    private List<PhoneNumberDTO> phones;

    private List<EmailDTO> emails;

    /**
     * 
     */
    private MaritalStatus maritalStatus;
    /**
     * 
     */
    private Title title;
    /**
     * 
     */
    private boolean tagniOrMagni;
  
    private List<PersonDTO> children;
  
    private List<PersonDTO> brotherSisters;
   
    private List<PersonDTO> tutors;
    
    private List<PersonDTO> friends;
 
    private List<PartenaireConjugalDTO> partnerships;
   
    private List<AddressDTO> addresses;
   
    private List<HandicapDTO> handicaps;
  
    private ReligionDTO religion;
  
    private BiometricCaracteristicsDTO biometricCaracteristics;
    
    private Regime regime;
}

