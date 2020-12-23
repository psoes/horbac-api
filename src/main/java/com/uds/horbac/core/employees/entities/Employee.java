package com.uds.horbac.core.employees.entities;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uds.horbac.core.emp_educationInfo.entities.Award;
import com.uds.horbac.core.emp_educationInfo.entities.School;
import com.uds.horbac.core.emp_healthInfo.entities.Hospital;
import com.uds.horbac.core.emp_healthInfo.entities.Pharmacy;
import com.uds.horbac.core.emp_justiceInfo.entities.LitigationJustice;
import com.uds.horbac.core.emp_ownershipInfo.entities.BankAccount;
import com.uds.horbac.core.emp_ownershipInfo.entities.BiensImmobiliers;
import com.uds.horbac.core.emp_ownershipInfo.entities.Device;
import com.uds.horbac.core.emp_ownershipInfo.entities.Vehicle;
import com.uds.horbac.core.emp_passionInfo.entities.HairdressingSalon;
import com.uds.horbac.core.emp_passionInfo.entities.Hobby;
import com.uds.horbac.core.emp_passionInfo.entities.Restaurant;
import com.uds.horbac.core.emp_passionInfo.entities.SewingSalon;
import com.uds.horbac.core.emp_passionInfo.entities.Visit;
import com.uds.horbac.core.emp_personalInfo.entities.Person;
import com.uds.horbac.core.emp_personalInfo.entities.SpecialIdentity;
import com.uds.horbac.core.emp_workInfo.entities.OccupiedFunction;

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
	@OneToOne
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
}

