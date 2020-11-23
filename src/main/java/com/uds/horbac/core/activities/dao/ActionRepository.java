package com.uds.horbac.core.activities.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uds.horbac.core.activities.entities.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long>{
	

}
