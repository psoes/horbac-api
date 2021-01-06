package com.uds.horbac.core.dto.contexts;

import java.time.Duration;
import java.time.Period;
import java.util.List;

import lombok.Data;

@Data
public class ContextDTO

{

    private Long id;
	
	/**
	 * the period (begin, and end)
	 */
	private Period period;
	
	/**
	 * duration in seconds, minutes or hours
	 */
	private Duration duration;

	private List<LocationDTO> locations; 
}

