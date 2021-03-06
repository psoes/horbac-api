package com.uds.horbac.core.entities.emp_personalInfo;
import java.awt.Color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BiometricCaracteristics
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Float weight;

    public Float height;

    public Color hairColor;

    public Color eyesColor;
 
    public Color skinColor;
}

