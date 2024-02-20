package com.uds.horbac.core.dao.units;

import com.uds.horbac.core.entities.units.UnitNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitNodeRepository extends JpaRepository<UnitNode, Long> {
    List<UnitNode> findAllByOrganizationId(Long id);
}