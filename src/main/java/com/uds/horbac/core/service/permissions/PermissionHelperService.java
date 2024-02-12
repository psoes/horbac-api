package com.uds.horbac.core.service.permissions;

import java.util.List;

import com.uds.horbac.core.entities.organizations.Organization;
import com.uds.horbac.core.entities.permissions.AdministrativePermission;
import com.uds.horbac.core.entities.permissions.CanSuggest;
import com.uds.horbac.core.entities.permissions.CanTreat;
import com.uds.horbac.core.entities.requests.HelperReponse;

public interface PermissionHelperService {	
	List<AdministrativePermission> canTreat(Organization org, CanTreat cant);
	HelperReponse canSuggest(Organization org, CanSuggest cans);

}
