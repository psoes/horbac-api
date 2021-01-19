
package com.uds.horbac.core.entities.emp_personalInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String pseudo;
    private Date birthDate;
    private Gender sex;
    //@ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
    //@ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<Email>();
    private Title title;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    private String avatar;
}

