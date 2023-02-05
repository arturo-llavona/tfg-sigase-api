package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasificacionIncidenteRepository extends JpaRepository<ClasificacionIncidenteEntity, Integer> {
    List<ClasificacionIncidenteEntity> findByCodigoStartingWith(String codigo);

}
