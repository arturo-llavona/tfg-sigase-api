package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.TipoRecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoRecursoRepository extends JpaRepository<TipoRecursoEntity, Integer> {
    @Query(value = "SELECT tr.* FROM tipo_recurso tr\n" +
            "\tinner join plantilla_clasificacion_incidente pci ON tr.id_tipo_recurso = pci.id_tipo_recurso\n" +
            "\tAND pci.id_clasificacion_incidente = ?1\n" +
            "\tAND tr.habilitado = true\n" +
            "\tORDER BY orden ASC", nativeQuery = true)
    List<TipoRecursoEntity> listResourcesByIncidentClassification(final Integer idClasificacionIncidente);
}
