package com.uds.horbac.core.dao.organizations;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uds.horbac.core.entities.emp_personalInfo.Person;
import com.uds.horbac.core.entities.organizations.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	@Transactional
	@Modifying
	@Query(value="UPDATE Organization o SET o.logo =:logo WHERE o.id =:id")
	void updateLogo(@Param("logo") String logo, @Param("id") Long id );

	List<Organization> findByOwner(Person owner);

	Organization findByIsDefault(boolean isDefault);

}
