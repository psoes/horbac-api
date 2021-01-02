package com.uds.horbac.core.dao.activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.entities.activities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
