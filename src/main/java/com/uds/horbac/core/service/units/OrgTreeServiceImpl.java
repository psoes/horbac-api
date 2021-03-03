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
		AdministrativeUnit root = getRoot(subordinates);		
		return  build(root, subordinates, unders);
	}
	
	private AdministrativeUnit getRoot(List<Subordinate> subs) {	
		AdministrativeUnit root = null;		
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
	
	public OrgTree build(AdministrativeUnit root, List<Subordinate> subs, List<PlaceUnder> places) { 
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
		if(res.get(0).getData() != null) traverse(res.get(0));
		return res.get(0);
	}
	
	void traverse(OrgTree child) {
		System.out.println(child.getData().getName());
		System.out.println("\t");
		for (OrgTree tree: child.getChildren()) {
			System.out.println(tree.getData().getName());
			traverse(tree);
		}
		
	}
	

}
