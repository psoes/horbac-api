package com.uds.horbac.core.dao.activities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.entities.activities.Consider;

@Repository
@RestController
public interface ConsiderRepository extends JpaRepository<Consider, Long>{

	List<Consider> findByActionId(Long id);

	Consider findByActionIdAndActivityIdAndOrganizationId(Long idAction, Long idActivity, Long idOrg);

	List<Consider> findByActivityId(Long id);

}
