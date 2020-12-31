package com.uds.horbac.core.emp_personalInfo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.emp_famillyInfo.entities.MaritalStatus;
import com.uds.horbac.core.emp_famillyInfo.entities.PartenaireConjugal;
import com.uds.horbac.core.emp_personalInfo.entities.Address;
import com.uds.horbac.core.emp_personalInfo.entities.BiometricCaracteristics;
import com.uds.horbac.core.emp_personalInfo.entities.Email;
import com.uds.horbac.core.emp_personalInfo.entities.Gender;
import com.uds.horbac.core.emp_personalInfo.entities.Handicap;
import com.uds.horbac.core.emp_personalInfo.entities.Person;
import com.uds.horbac.core.emp_personalInfo.entities.PhoneNumber;
import com.uds.horbac.core.emp_personalInfo.entities.Religion;
import com.uds.horbac.core.emp_personalInfo.entities.Title;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String pseudo;

    private Date birthDate;
 
    private Gender sex;

    private List<PhoneNumber> phones;

    private List<Email> emails;

    private MaritalStatus maritalStatus;

    private Title title;

    private boolean tagniOrMagni;

    private List<PersonDTO> children;

    private List<PersonDTO> brotherSisters;

    private List<PersonDTO> tutors;

    private List<PersonDTO> friends;

    private List<PartenaireConjugal> partners;

    private List<Address> addresses;

    private List<Handicap> handicaps;

    private Religion religion;

    private BiometricCaracteristics biometricCaracteristics;
}
