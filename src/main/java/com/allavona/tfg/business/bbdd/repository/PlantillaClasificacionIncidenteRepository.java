package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.PlantillaClasificacionIncidenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantillaClasificacionIncidenteRepository extends JpaRepository<PlantillaClasificacionIncidenteEntity, Integer> {
    List<PlantillaClasificacionIncidenteEntity> findAllByIdClasificacionIncidente(Integer idClasificacionIncidente);
}
