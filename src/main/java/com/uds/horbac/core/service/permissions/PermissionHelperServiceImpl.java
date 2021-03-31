package com.uds.horbac.core.service.permissions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.dao.activities.ConsiderRepository;
import com.uds.horbac.core.dao.contexts.DefineRepository;
import com.uds.horbac.core.dao.employees.AppointsRepository;
import com.uds.horbac.core.dao.employees.EmploysRepository;
import com.uds.horbac.core.dao.permissions.AdministrativePermissionRepository;
import com.uds.horbac.core.dao.permissions.OperationalPermissionRepository;
import com.uds.horbac.core.dao.resources.UsesRepository;
import com.uds.horbac.core.dao.units.PlaceUnderRepository;
import com.uds.horbac.core.entities.activities.Activity;
import com.uds.horbac.core.entities.activities.Consider;
import com.uds.horbac.core.entities.contexts.Context;
import com.uds.horbac.core.entities.contexts.Define;
import com.uds.horbac.core.entities.employees.Appoints;
import com.uds.horbac.core.entities.employees.Employs;
import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.permissions.AdministrativePermission;
import com.uds.horbac.core.entities.permissions.CanSuggest;
import com.uds.horbac.core.entities.permissions.CanTreat;
import com.uds.horbac.core.entities.permissions.OperationalPermission;
import com.uds.horbac.core.entities.resources.Uses;
import com.uds.horbac.core.entities.resources.Vue;
import com.uds.horbac.core.entities.units.AdministrativeUnit;
import com.uds.horbac.core.entities.units.OperationalUnit;
import com.uds.horbac.core.entities.units.PlaceUnder;

@Service
public class PermissionHelperServiceImpl implements PermissionHelperService{
	
	
	@Autowired
	private AdministrativePermissionRepository adminPermissionRepository;
	
	@Autowired
	private OperationalPermissionRepository opPermissionRepository;
	
	@Autowired
	private EmploysRepository employsRepository;
	
	@Autowired
	private AppointsRepository appointsRepository;
	

	
	@Autowired 
	private UsesRepository usesRepository;
	
	@Autowired
	private ConsiderRepository considerRepository;

	
	@Autowired
	private DefineRepository defineRepository;
	
	@Autowired
	private PlaceUnderRepository placeUnderRepository;
	

	@Override
	public List<OperationalPermission> canSuggest(Organization org, CanSuggest cans) {	
		//java.util.function.Predicate<String> predicate2 = str -> str.isEmpty();
		//java.util.function.Predicate<Employs> pred = emp -> emp.getEmployee().getId() == cans.getEmitter().getId();
	    //List<Employee> find = repository.findByIdAndNameAndAddressCity(id, name, city);
		//Predicate<String> predicate2 =  str.length() < 4;
		Employs emp = employsRepository.findAllByOrganizationAndEmployee(org, cans.getEmitter());		
		OperationalUnit ou = emp != null ? emp.getOperationalUnit() : null;
		Consider con = considerRepository.findAllByOrganizationAndAction(org, cans.getAction());
		Activity a = con!=null ? con.getActivity() : null ;
		Uses uses =  usesRepository.findAllByOrganizationAndResource(org, cans.getResource());
		Vue v = uses!=null ? uses.getVue() : null;
		Define def  = defineRepository.findAllByOrganizationAndEmployeeAndActionAndResource(org, cans.getEmitter(), cans.getAction(), cans.getResource());
		Context c = def != null ? def.getContext() : null;
			
		Specification<OperationalPermission> secSpec = new Specification<OperationalPermission>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<OperationalPermission> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
	            if(ou != null)predicates.add(criteriaBuilder.equal(root.get("unit").get("id"), ou.getId()));
	           
	            if(a != null)predicates.add(criteriaBuilder.equal(root.get("activity").get("id"), a.getId()));
	            
	            if(v != null)predicates.add(criteriaBuilder.equal(root.get("vue").get("id"), v.getId()));
	           
	            if(c != null)predicates.add(criteriaBuilder.equal(root.get("context").get("id"), c.getId()));
	            
	            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}		 		
		};
		if(ou == null) return null;
		if(a == null) return null;
		if(v == null) return null;
		
		List<OperationalPermission> ops = opPermissionRepository.findAll(secSpec);		
		return ops;
			
	}



	@Override
	public List<AdministrativePermission> canTreat(Organization org, CanTreat cant) {
		
		Appoints ap = appointsRepository.findAllByOrganizationAndEmployee(org, cant.getApprover());
		
		AdministrativeUnit au  = ap != null ? ap.getAdminUnit() : null;
		
		Employs emp = employsRepository.findAllByOrganizationAndEmployee(org, cant.getEmitter());		
		OperationalUnit ou = emp != null ? emp.getOperationalUnit() : null;
		Consider con = considerRepository.findAllByOrganizationAndAction(org, cant.getAction());
		Activity a = con!=null ? con.getActivity() : null ;
		Uses uses =  usesRepository.findAllByOrganizationAndResource(org, cant.getResource());
		Vue v = uses!=null ? uses.getVue() : null;
		Define def  = defineRepository.findAllByOrganizationAndEmployeeAndActionAndResource(org, cant.getApprover(), cant.getAction(), cant.getResource());
		Context c = def != null ? def.getContext() : null;
		
		PlaceUnder pl = placeUnderRepository.findAllByOrganizationAndSuperiorAndSubordinate(org, au, ou);
		OperationalUnit ou1 = pl != null ? pl.getSubordinate() : null;
		Specification<AdministrativePermission> secSpec = new Specification<AdministrativePermission>() {
	 		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<AdministrativePermission> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
	            if(ou1 != null)predicates.add(criteriaBuilder.equal(root.get("operationalUnit").get("id"), ou.getId()));
	            if(au != null)predicates.add(criteriaBuilder.equal(root.get("administrativeUnit").get("id"), au.getId()));
	            if(a != null)predicates.add(criteriaBuilder.equal(root.get("activity").get("id"), a.getId()));
	            if(v != null)predicates.add(criteriaBuilder.equal(root.get("vue").get("id"), v.getId()));
	            if(c != null)predicates.add(criteriaBuilder.equal(root.get("context").get("id"), c.getId()));
	            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}		 		
		};
		if(ou1 == null) return null;
		if(au == null) return null;
		if(a == null) return null;
		if(v == null) return null;
		List<AdministrativePermission> ops = adminPermissionRepository.findAll(secSpec);		
		return ops;
			
	}
	
	

}
