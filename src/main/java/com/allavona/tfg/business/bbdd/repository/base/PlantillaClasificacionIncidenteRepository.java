package com.allavona.tfg.business.bbdd.repository.base;

import com.allavona.tfg.business.bbdd.entity.base.PlantillaClasificacionIncidenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantillaClasificacionIncidenteRepository extends JpaRepository<PlantillaClasificacionIncidenteEntity, Integer> {
    List<PlantillaClasificacionIncidenteEntity> findAll();
}