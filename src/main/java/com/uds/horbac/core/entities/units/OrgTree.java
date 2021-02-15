package com.uds.horbac.core.entities.units;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class OrgTree implements Serializable{
	
	/**
	 * 
	 */
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

}
		
		


