package com.uds.horbac.core.organizations.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.organizations.entities.SocialReason;

@Repository
public interface SocialReasonRepository extends JpaRepository<SocialReason, Long>{

}
