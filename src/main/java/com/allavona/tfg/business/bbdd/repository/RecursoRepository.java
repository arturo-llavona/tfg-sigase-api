package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Integer> {
    List<RecursoEntity> findByHabilitadoTrue();
}
