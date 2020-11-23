package com.uds.horbac.core.employees;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class WorkEmployee

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
    private String middleName;
    /**
     * 
     */
    private String lastName;
    /**
     * 
     */
    private Gender gender;
    /**
     * 
     */
    private Date dateOfBirth;
    /**
     * 
     */
    private String nid;
    /**
     * 
     */
    private String placeOfBirth;
    /**
     * Operation getFullName
     *
     * @return String
     */
    public String getFullName (  ){
    	return firstName + " "+ lastName;
    }
}

