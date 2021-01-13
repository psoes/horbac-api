package com.uds.horbac.core.entities.employees;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.entities.emp_educationInfo.Award;
import com.uds.horbac.core.entities.emp_educationInfo.School;
import com.uds.horbac.core.entities.emp_famillyInfo.MaritalStatus;
import com.uds.horbac.core.entities.emp_famillyInfo.PartenaireConjugal;
import com.uds.horbac.core.entities.emp_healthInfo.Hospital;
import com.uds.horbac.core.entities.emp_healthInfo.Pharmacy;
import com.uds.horbac.core.entities.emp_justiceInfo.LitigationJustice;
import com.uds.horbac.core.entities.emp_ownershipInfo.BankAccount;
import com.uds.horbac.core.entities.emp_ownershipInfo.BiensImmobiliers;
import com.uds.horbac.core.entities.emp_ownershipInfo.Device;
import com.uds.horbac.core.entities.emp_ownershipInfo.Vehicle;
import com.uds.horbac.core.entities.emp_passionInfo.HairdressingSalon;
import com.uds.horbac.core.entities.emp_passionInfo.Hobby;
import com.uds.horbac.core.entities.emp_passionInfo.Restaurant;
import com.uds.horbac.core.entities.emp_passionInfo.SewingSalon;
import com.uds.horbac.core.entities.emp_passionInfo.Visit;
import com.uds.horbac.core.entities.emp_personalInfo.BiometricCaracteristics;
import com.uds.horbac.core.entities.emp_personalInfo.Handicap;
import com.uds.horbac.core.entities.emp_personalInfo.Person;
import com.uds.horbac.core.entities.emp_personalInfo.Regime;
import com.uds.horbac.core.entities.emp_personalInfo.Religion;
import com.uds.horbac.core.entities.emp_personalInfo.SpecialIdentity;
import com.uds.horbac.core.entities.emp_workInfo.OccupiedFunction;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Person

{
    /** Attributes */
    /**
     * 
     */
	@OneToMany
    private List<SewingSalon> sewingSalons;
    /**
     * 
     */
	@OneToMany
    private List<HairdressingSalon> hairdressingSalons;
    /**
     * 
     */
	@OneToMany
    private List<Restaurant> restaurants;
    /**
     * 
     */
	@OneToMany
    private List<Hobby> hobbies;
    /**
     * 
     */
	@OneToMany
    private List<BiensImmobiliers> biensImmobiliers;
    /**
     * 
     */
	@OneToMany
    private List<Vehicle> vehicules;
    /**
     * 
     */
	@OneToMany
    private List<BankAccount> bankAccounts;
    /**
     * 
     */
	@OneToMany
    private List<Award> awards;
    /**
     * 
     */
	@OneToMany
    private List<Visit> visits;
    /**
     * 
     */
	@OneToMany
    private List<School> schools;
    /**
     * 
     */
	@OneToOne(cascade = CascadeType.PERSIST)
    private SpecialIdentity specialID;
    /**
     * 
     */
	@OneToMany
    private List<Pharmacy> pharmacies;
    /**
     * 
     */
	@OneToMany
    private List<OccupiedFunction> occupiedFunctions;
    /**
     * 
     */
	@OneToMany
    private List<Device> devices;
    
    @OneToMany
    private List<LitigationJustice> litigationJustices;
    
    /**
     * 
     */
	@OneToMany
    private List<Hospital> hospitals;
	
	/**
     * 
     */
    private MaritalStatus maritalStatus;
 
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
   
    @OneToMany
    private List<Handicap> handicaps;
 
    @OneToOne
    private Religion religion;
  
    @OneToOne
    private BiometricCaracteristics biometricCaracteristics;
    
    private Regime regime;
}

