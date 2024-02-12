package com.uds.horbac.configs;


import com.uds.horbac.core.entities.units.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

import com.uds.horbac.core.entities.contexts.AcceptedDevice;
import com.uds.horbac.core.entities.contexts.HOLocation;
import com.uds.horbac.core.entities.contexts.HOPeriod;
import com.uds.horbac.core.entities.employees.Appoints;
import com.uds.horbac.core.entities.employees.Employs;
import com.uds.horbac.core.entities.organizations.OrganizationType;
import com.uds.horbac.core.entities.organizations.SocialReason;
import com.uds.horbac.core.entities.resources.Resource;
import com.uds.horbac.core.entities.resources.Vue;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(SocialReason.class);
        config.exposeIdsFor(OrganizationType.class);
        config.exposeIdsFor(AdministrativeUnit.class);
        config.exposeIdsFor(Subordinate.class);
        config.exposeIdsFor(OperationalUnit.class);
        config.exposeIdsFor(OrgUnit.class);
        config.exposeIdsFor(PlaceUnder.class);
        config.exposeIdsFor(Appoints.class);
        config.exposeIdsFor(Employs.class);
        config.exposeIdsFor(HOLocation.class);
        config.exposeIdsFor(AcceptedDevice.class);
        config.exposeIdsFor(HOPeriod.class);
        config.exposeIdsFor(Resource.class);
        config.exposeIdsFor(Vue.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }
}