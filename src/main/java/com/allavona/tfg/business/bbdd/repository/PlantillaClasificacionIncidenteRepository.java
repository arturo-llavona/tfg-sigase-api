package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.PlantillaClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.TipoRecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantillaClasificacionIncidenteRepository extends JpaRepository<PlantillaClasificacionIncidenteEntity, Integer> {
    List<PlantillaClasificacionIncidenteEntity> findAll();
}
