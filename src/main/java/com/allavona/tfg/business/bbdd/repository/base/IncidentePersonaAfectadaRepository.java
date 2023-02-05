package com.allavona.tfg.business.bbdd.repository.base;

import com.allavona.tfg.business.bbdd.entity.base.IncidentePersonaAfectadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentePersonaAfectadaRepository extends JpaRepository<IncidentePersonaAfectadaEntity, Integer> {
    IncidentePersonaAfectadaEntity findByIdIncidente(Integer idIncidente);
}
