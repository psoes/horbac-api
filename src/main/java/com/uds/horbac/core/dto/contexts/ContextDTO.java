package com.uds.horbac.core.dto.contexts;

import java.util.List;

import lombok.Data;

@Data
public class ContextDTO {
	 	private Long id;		
		private String name;		
		private List<HOPeriodDTO> periods;		
		private List<HOLocationDTO> locations;		
		private List<AcceptedDeviceDTO> devices;
}

