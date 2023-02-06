package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Integer> {
    @Query(value = "SELECT * FROM recurso WHERE id_tipo_recurso = ?1 AND habilitado IS TRUE;", nativeQuery = true)
    List<RecursoEntity> findRecursosHabilitados(final Integer idTipoRecurso);
    @Query(value = "SELECT * FROM recurso WHERE habilitado IS TRUE;", nativeQuery = true)
    List<RecursoEntity> findRecursosHabilitados();

    @Query(value = "SELECT * FROM recurso r WHERE r.habilitado IS TRUE AND r.id_recurso NOT IN (SELECT distinct id_recurso FROM incidente_recurso ir WHERE id_codigo_finalizacion IS NOT NULL);", nativeQuery = true)
    List<RecursoEntity> findRecursosDisponibles();
    @Query(value = "SELECT * FROM recurso r WHERE r.id_tipo_recurso = ?1 AND r.habilitado IS TRUE AND r.id_recurso NOT IN (SELECT distinct id_recurso FROM incidente_recurso ir WHERE id_codigo_finalizacion IS NOT NULL);", nativeQuery = true)
    List<RecursoEntity> findRecursosDisponibles(final Integer idTipoRecurso);
}
