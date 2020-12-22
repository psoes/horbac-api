package com.uds.horbac.core.contexts;

import java.time.Duration;
import java.time.Period;
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
	
	/**
	 * the period (begin, and end)
	 */
	private Period period;
	
	/**
	 * duration in seconds, minutes or hours
	 */
	private Duration duration;
		
	
	@OneToMany
	private List<Location> locations; 
}

