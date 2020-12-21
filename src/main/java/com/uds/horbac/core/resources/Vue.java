package com.uds.horbac.core.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vue

{
    /** Attributes */
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
  
    private String name;
}

