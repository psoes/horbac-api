package com.uds.horbac.core.dto.emp_personalInfo;
import java.awt.Color;

import lombok.Data;

@Data
public class BiometricCaracteristicsDTO

{
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

