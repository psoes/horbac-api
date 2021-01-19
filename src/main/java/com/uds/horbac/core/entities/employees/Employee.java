package com.uds.horbac.core.entities.employees;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.dto.emp_passionInfo.FoodRegime;
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
import com.uds.horbac.core.entities.emp_personalInfo.Cigarette;
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
    /**
     * passion
     */
	@OneToMany
    private List<SewingSalon> sewingSalons;
    /**
     * pasion
     */
	@OneToMany
    private List<HairdressingSalon> hairdressingSalons;
    /**
     * passion
     */
	@OneToMany
    private List<Restaurant> restaurants;
    /**
     * ownership
     */
	@OneToMany
    private List<Hobby> hobbies;
    /**
     * ownership
     */
	@OneToMany
    private List<BiensImmobiliers> biensImmobiliers;
    /**
     * ownership
     */
	@OneToMany
    private List<Vehicle> vehicules;
    /**
     * ownership
     */
	@OneToMany
    private List<BankAccount> bankAccounts;
    /**
     * education
     */
	@OneToMany
    private List<Award> awards;
    /**
     * passion info
     */
	@OneToMany
    private List<Visit> visits;
    /**
     * education info
     */
	@OneToMany
    private List<School> schools;
    /**
     * personal info
     */
	@OneToOne(cascade = CascadeType.PERSIST)
    private SpecialIdentity specialID;
	
	/**
	 * health info
	 */
	@OneToMany
    private List<Pharmacy> pharmacies;
	
	/**
	 * work info
	 */
	@OneToMany
    private List<OccupiedFunction> occupiedFunctions;
	
	/**
	 * ownership info
	 */
	@OneToMany
    private List<Device> devices;
	
	/**
	 * justice info
	 */
    @OneToMany
    private List<LitigationJustice> litigationJustices;
    
    /**
     * health info
     */
	@OneToMany
    private List<Hospital> hospitals;
	
	/**
	 * familly info
	 */
    private MaritalStatus maritalStatus;
    
    /**
     * familly info
     */
    private boolean tagniOrMagni;
    
    /**
     * familly info
     */
    @OneToMany
    private List<Person> children;
    
    /**
     * familly info
     */
    @OneToMany
    private List<Person> brotherSisters;
    
    /**
     * familly info
     */
    @OneToMany
    private List<Person> tutors;
    
    /**
     * familly info
     */
    @OneToMany
    private List<Person> friends;
    
    /**
     * familly info
     */
    @OneToMany
    private List<PartenaireConjugal> partnerships;
   
    /**
     * personal info
     */
    @OneToMany
    private List<Handicap> handicaps;
    
    /**
     * personal info
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private Religion religion;
    /**
     * health info
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private BiometricCaracteristics biometricCaracteristics;
    
    /**
     * familly info
     */
    private Regime regime;
    
    /**
     * health info
     */
    private Cigarette cigarette;
    
    /**
     * passion info
     */
    private FoodRegime foodRegime;
}

