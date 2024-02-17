package com.uds.horbac.core.dao.units;


import com.uds.horbac.core.entities.units.AdministrativeUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUnitSimpleRepository extends JpaRepository<AdministrativeUnit, Long> {
    List<AdministrativeUnit> findAllByOrganizationId(Long id);
}
