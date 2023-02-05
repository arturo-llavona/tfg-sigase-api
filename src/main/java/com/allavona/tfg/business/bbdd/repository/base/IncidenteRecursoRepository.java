package com.allavona.tfg.business.bbdd.repository.base;

import com.allavona.tfg.business.bbdd.entity.base.IncidenteRecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidenteRecursoRepository extends JpaRepository<IncidenteRecursoEntity, Integer> {
    List<IncidenteRecursoEntity> findAllByIdIncidente(Integer idIncidente);
}
