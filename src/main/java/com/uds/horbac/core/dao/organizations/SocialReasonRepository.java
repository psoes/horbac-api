package com.uds.horbac.core.dao.organizations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.entities.organizations.SocialReason;

@Repository
public interface SocialReasonRepository extends JpaRepository<SocialReason, Long>{

}
