package com.uds.horbac.core.service.units;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.units.AdministrativeUnit;
import com.uds.horbac.core.entities.units.OrgTree;
import com.uds.horbac.core.entities.units.OrgUnit;
import com.uds.horbac.core.entities.units.PlaceUnder;
import com.uds.horbac.core.entities.units.Subordinate;

@Service
public class OrgTreeServiceImpl implements OrgTreeService{
	

	@Autowired 
	protected SubordinateService subordinateService;
	
	@Autowired
	protected PlaceUnderService placeUnderService;

	@Override
	public OrgTree getOrgTree(Organization org) {
		List<Subordinate> subordinates = subordinateService.findByOrganization(org);
		List<PlaceUnder> unders = placeUnderService.findByOrganization(org);
		OrgUnit root = getRoot(subordinates);		
		return  build(root, subordinates, unders);
	}
	
	private OrgUnit getRoot(List<Subordinate> subs) {	
		OrgUnit root = null;		
		for (Subordinate subordinate : subs) {
			AdministrativeUnit rootFind = subordinate.getSuperior();
			boolean ok = subs.stream().anyMatch(item -> item.getSubordinate().getId() == rootFind.getId());
			if(!ok) {
				root = rootFind; 
				break;
			}	
		}
		return root;
		
	}	
	
	public OrgTree build(OrgUnit root, List<Subordinate> subs, List<PlaceUnder> places) { 
		List<OrgTree> res = new ArrayList<OrgTree>();
		ArrayDeque<OrgTree> queue = new ArrayDeque<OrgTree>();
		queue.add(new OrgTree(root));
		while(!queue.isEmpty()) {
			OrgTree current = queue.remove();
			List<OrgTree> children = null;
			List<OrgTree> othersChildren = null;
			
			if(current.getData() instanceof AdministrativeUnit) {
				children =  subs.stream().filter(item -> item.getSuperior().getId() == current.getData().getId())
				.map(item -> {OrgTree t = new OrgTree(item.getSubordinate()); t = current.addChild(t); return t;}).collect(Collectors.toList());
		    	
				othersChildren = places.stream().filter(item -> item.getSuperior().getId() == current.getData().getId())
						.map(item -> {OrgTree t = new OrgTree(item.getSubordinate()); t = current.addChild(t); return t;}).collect(Collectors.toList());
				
				if(children != null )queue.addAll(children);
				if(othersChildren != null )queue.addAll(othersChildren);
			
			}
			res.add(current);  
		   
		}
		return res.get(0);
	}
	

}
