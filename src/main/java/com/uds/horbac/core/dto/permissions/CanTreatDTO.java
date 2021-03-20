package com.uds.horbac.core.dto.permissions;
import com.uds.horbac.core.dto.activities.ActionDTO;
import com.uds.horbac.core.dto.employees.ApproverDTO;
import com.uds.horbac.core.dto.employees.EmitterDTO;
import com.uds.horbac.core.dto.resources.ResourceDTO;

import lombok.Data;

@Data
public class CanTreatDTO {
	private ActionDTO action;
	private EmitterDTO emitter;
	private ApproverDTO approver;
	private ResourceDTO resource;
}
