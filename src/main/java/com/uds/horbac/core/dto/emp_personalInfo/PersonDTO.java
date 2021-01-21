
package com.uds.horbac.core.dto.emp_personalInfo;
import java.util.Date;
import java.util.List;

import com.uds.horbac.core.entities.emp_personalInfo.Gender;
import com.uds.horbac.core.entities.emp_personalInfo.Title;

import lombok.Data;

@Data
public class PersonDTO

{
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String pseudo;
    private Date birthDate;
    private Gender sex;
    private List<PhoneNumberDTO> phones;
    private List<EmailDTO> emails;
    private Title title;
    private List<AddressDTO> addresses;
    private String avatar;
}

