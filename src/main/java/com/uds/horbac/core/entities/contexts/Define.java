package com.uds.horbac.core.entities.contexts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uds.horbac.core.entities.activities.Action;
import com.uds.horbac.core.entities.employees.Employee;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.resources.Resource;

import lombok.Data;

@Entity
@Data
public class Define {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
	
	@ManyToOne
    private Employee employee;

	@ManyToOne
    private Context context;
	
	@ManyToOne
    private Action action;
	
	@ManyToOne
	private Resource resource;
	
	@ManyToOne
	private Organization organization;
}

