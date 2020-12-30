
package com.uds.horbac.core.emp_personalInfo.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.emp_famillyInfo.entities.MaritalStatus;
import com.uds.horbac.core.emp_famillyInfo.entities.PartenaireConjugal;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public class Person

{
    /** Attributes */
    /**
     * 
     */
	@Id
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
    /**
     * 
     */
    @OneToMany
    private List<PhoneNumber> phones;
    /**
     * 
     */
    @OneToMany
    private List<Email> emails;

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
    /**
     * 
     */
    @OneToMany
    private List<Person> children;
    /**
     * 
     */
    @OneToMany
    private List<Person> brotherSisters;
    /**
     * 
     */
    @OneToMany
    private List<Person> tutors;
    /**
     * 
     */
    @OneToMany
    private List<Person> friends;
    /**
     * 
     */
    @OneToMany
    private List<PartenaireConjugal> partnerships;
    /**
     * 
     */
    @OneToMany
    private List<Address> addresses;
    /**
     * 
     */
    @OneToMany
    private List<Handicap> handicaps;
    /**
     * 
     */
    @OneToOne
    private Religion religion;
    /**
     * 
     */
    @OneToOne
    private BiometricCaracteristics biometricCaracteristics;
    
    private Regime regime;
}

