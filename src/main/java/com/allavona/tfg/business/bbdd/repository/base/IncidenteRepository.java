package com.allavona.tfg.business.bbdd.repository.base;

import com.allavona.tfg.business.bbdd.entity.base.IncidenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidenteRepository extends JpaRepository<IncidenteEntity, Integer> {
    List<IncidenteEntity> findByFechaFinalizacionIsNull();
    List<IncidenteEntity> findByFechaFinalizacionIsNotNull();
}
