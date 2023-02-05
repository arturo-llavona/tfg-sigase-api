package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.IncidenteRecursoEstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IncidenteRecursoEstadoRepository extends JpaRepository<IncidenteRecursoEstadoEntity, Integer> {
    @Query(value = "SELECT * FROM incidente_recurso_estado WHERE id_recurso = ?1 AND id_incidente = ?2 ORDER BY fecha DESC LIMIT 1;", nativeQuery = true)
    IncidenteRecursoEstadoEntity findByIdRecursoAndIdIncidente(Integer idRecurso, Integer idIncidente);


}
