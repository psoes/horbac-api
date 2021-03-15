package com.uds.horbac.core.entities.contexts;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Context

{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private String name;
	/**
	 * The period (begin, and end)
	 */
	@OneToMany
	private List<HOPeriod> periods;
	
	@OneToMany
	private List<HOLocation> locations; 
	
	/**
	 * The list of devices
	 */
	@OneToMany
	private List<AcceptedDevice> devices; 
	
}

