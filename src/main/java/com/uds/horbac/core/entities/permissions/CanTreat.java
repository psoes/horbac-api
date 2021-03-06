package com.uds.horbac.core.entities.permissions;

import com.uds.horbac.core.entities.activities.Action;
import com.uds.horbac.core.entities.employees.Approver;
import com.uds.horbac.core.entities.employees.Emitter;
import com.uds.horbac.core.entities.resources.Resource;

import lombok.Data;

@Data
public class CanTreat {
	private Action action;
	private Approver approver;
	private Emitter emitter;
	private Resource resource;
}

