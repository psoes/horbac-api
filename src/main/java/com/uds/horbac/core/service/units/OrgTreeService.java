package com.uds.horbac.core.service.units;

import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.units.OrgTree;

public interface OrgTreeService {
	public OrgTree getOrgTree(Organization org);
}
