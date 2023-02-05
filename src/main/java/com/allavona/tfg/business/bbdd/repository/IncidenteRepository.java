package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidenteRepository extends JpaRepository<IncidenteEntity, Integer> {
    List<IncidenteEntity> findByFechaFinalizacionIsNull();
    List<IncidenteEntity> findByFechaFinalizacionIsNotNull();
}
