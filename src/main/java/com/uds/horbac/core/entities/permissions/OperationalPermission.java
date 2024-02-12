package com.uds.horbac.core.entities.permissions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.activities.Activity;
import com.uds.horbac.core.entities.contexts.Context;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.resources.Vue;
import com.uds.horbac.core.entities.units.OperationalUnit;

import com.uds.horbac.core.entities.units.OrgUnit;
import lombok.Data;

import java.time.Duration;

@Data
@Entity
public class OperationalPermission

{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private String name;
	 
	@ManyToOne
    private Activity activity;
	
	@ManyToOne
    private Vue vue;
	
	@ManyToOne
    private Context context;
	
	@ManyToOne
    private OrgUnit unit;
	
	@ManyToOne
	private Organization organization;
	
	private TreatmentMode mode;

	private Boolean requiredApproval;

	private Integer approvalLevel;

	private Integer priority;
	private Integer timeout;

	private ApprovalType approvalType;
	
}

