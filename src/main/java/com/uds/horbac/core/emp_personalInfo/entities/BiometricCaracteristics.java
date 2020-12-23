package com.uds.horbac.core.emp_personalInfo.entities;
import java.awt.Color;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BiometricCaracteristics

{
    /** Attributes */
    /**
     * 
     */
	@Id
    public Long id;
    /**
     * 
     */
    public Float weight;
    /**
     * 
     */
    public Float height;
    /**
     * 
     */
    public Color hairColor;
    /**
     * 
     */
    public Color eyesColor;
    /**
     * 
     */
    public Color skinColor;
}

