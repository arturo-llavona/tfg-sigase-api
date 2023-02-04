package com.allavona.tfg.business.bbdd.repository.base;

import com.allavona.tfg.business.bbdd.entity.base.ClasificacionIncidenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasificacionIncidenteRepository extends JpaRepository<ClasificacionIncidenteEntity, Integer> {
    List<ClasificacionIncidenteEntity> findByCodigoStartingWith(String codigo);

}
