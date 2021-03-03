package com.uds.horbac.configs;


import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

import com.uds.horbac.core.entities.employees.Appoints;
import com.uds.horbac.core.entities.employees.Employs;
import com.uds.horbac.core.entities.organizations.OrganizationType;
import com.uds.horbac.core.entities.organizations.SocialReason;
import com.uds.horbac.core.entities.units.AdministrativeUnit;
import com.uds.horbac.core.entities.units.OperationalUnit;
import com.uds.horbac.core.entities.units.PlaceUnder;
import com.uds.horbac.core.entities.units.Subordinate;

@Component
public class RestConfig implements RepositoryRestConfigurer {
	
	@Override
      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(SocialReason.class);
        config.exposeIdsFor(OrganizationType.class);
        config.exposeIdsFor(AdministrativeUnit.class);
        config.exposeIdsFor(Subordinate.class);
        config.exposeIdsFor(OperationalUnit.class);
        config.exposeIdsFor(PlaceUnder.class);
        config.exposeIdsFor(Appoints.class);
        config.exposeIdsFor(Employs.class);
      }
}