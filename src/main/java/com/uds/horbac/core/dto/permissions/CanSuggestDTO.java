package com.uds.horbac.core.dto.permissions;

import com.uds.horbac.core.dto.activities.ActionDTO;
import com.uds.horbac.core.dto.employees.ApproverDTO;
import com.uds.horbac.core.dto.resources.ResourceDTO;
import lombok.Data;

@Data
public class CanSuggestDTO {
	private ActionDTO action;
	private ApproverDTO approver;
	private ResourceDTO resource;
}
