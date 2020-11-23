package com.uds.horbac.core.activities.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.activities.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
