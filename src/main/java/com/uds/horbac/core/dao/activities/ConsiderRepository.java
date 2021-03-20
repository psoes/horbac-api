package com.uds.horbac.core.dao.activities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.entities.activities.Action;
import com.uds.horbac.core.entities.activities.Activity;
import com.uds.horbac.core.entities.activities.Consider;
import com.uds.horbac.core.entities.organizations.Organization;

@Repository
@RestController
public interface ConsiderRepository extends JpaRepository<Consider, Long>{

	List<Consider> findByActionId(Long id);

	Consider findByActionIdAndActivityIdAndOrganizationId(Long idAction, Long idActivity, Long idOrg);

	List<Consider> findByActivityId(Long id);

	Consider findAllByOrganizationIdAndActionId(Long orgId, Long actionId);

	Consider findAllByOrganizationAndAction(Organization org, Action action);

}
