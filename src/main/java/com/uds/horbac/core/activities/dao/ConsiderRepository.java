package com.uds.horbac.core.activities.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.uds.horbac.core.activities.entities.Consider;

@Repository
@RestController
public interface ConsiderRepository extends JpaRepository<Consider, Long>{

}
