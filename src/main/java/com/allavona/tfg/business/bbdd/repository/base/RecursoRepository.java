package com.allavona.tfg.business.bbdd.repository.base;

import com.allavona.tfg.business.bbdd.entity.base.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Integer> {
    List<RecursoEntity> findByHabilitadoTrue();
}
