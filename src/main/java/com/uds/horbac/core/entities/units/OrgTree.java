package com.uds.horbac.core.entities.units;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class OrgTree implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private OrgUnit data;	
	//@JsonManagedReference
	@JsonBackReference
	private OrgTree parent;	
    private List<OrgTree> children;	
	
    public OrgTree(OrgUnit val) {
        data = val;
        children = new ArrayList<OrgTree>();
    }
   
    public OrgTree addChild(OrgTree t) {
        t.setParent(this);
        children.add(t);
        return t;
    }

    public static List<OrgUnit> getApprovers(OrgTree tree, OrgUnit unit, int level) {
        List<OrgUnit> approvers = new ArrayList<>();
        if (level == 0 || unit == null) {
            return approvers; // Edge case: level 0 or null unit
        }

        OrgTree current = findUnitInTree(tree, unit);
        int currentLevel = 0;

        while (current != null && currentLevel < level+1) {
            approvers.add(current.getData()); // Add the OrgUnit data directly
            current = current.getParent();
            currentLevel++;
        }

        //Collections.reverse(approvers); // Ensure correct order
        return approvers.stream().filter(u -> !Objects.equals(u.getId(), unit.getId())).collect(Collectors.toList());
    }
    private static OrgTree findUnitInTree(OrgTree tree, OrgUnit unit) {
        if (tree.getData().equals(unit)) {
            return tree;
        }

        for (OrgTree child : tree.getChildren()) {
            OrgTree found = findUnitInTree(child, unit);
            if (found != null) {
                return found;
            }
        }

        return null; // Unit not found
    }



}
		
		


