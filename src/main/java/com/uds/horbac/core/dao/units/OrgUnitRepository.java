package com.uds.horbac.core.dao.units;

import com.uds.horbac.core.annotations.IsAllowed;
import com.uds.horbac.core.security.ActivityType;
import com.uds.horbac.core.security.ViewType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uds.horbac.core.entities.units.OrgUnit;

import io.swagger.annotations.Api;

import java.util.List;

/**
* Generated by Spring Data Generator on 31/12/2020
*/
@Api(tags = "OrgUnit Entity")
@RepositoryRestResource(path = "org-units", exported = true)
public interface OrgUnitRepository extends JpaRepository<OrgUnit, Long>, JpaSpecificationExecutor<OrgUnit>{

    @Override
    @IsAllowed(activity = ActivityType.CREATE, view = ViewType.UNITS)
    OrgUnit save(OrgUnit orgUnit);

    @Override
    @IsAllowed(view = ViewType.UNITS, activity = ActivityType.VIEW)
    Page<OrgUnit> findAll(Pageable pageable);
}

