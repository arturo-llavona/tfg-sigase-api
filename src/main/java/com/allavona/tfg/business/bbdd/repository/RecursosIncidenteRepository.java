package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.RecursoEstadoCompletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecursosIncidenteRepository extends JpaRepository<RecursoEstadoCompletoEntity, Integer>  {
    @Query(value = "SELECT\n" +
            "\tr.id_tipo_recurso,\n" +
            "\tr.id_recurso,\n" +
            "\tr.nombre as nombre_recurso,\n" +
            "\tir.id_codigo_finalizacion,\n" +
            "\tir.fecha_movilizacion,\n" +
            "\tr.es_consulta_sanitaria,\n" +
            "\tmax(ire.fecha) as fecha_estado,\n" +
            "\tmax(ire.id_incidente_recurso_estado) as id_incidente_recurso_estado\n" +
            "FROM incidente i\n" +
            "\tINNER JOIN incidente_recurso ir ON i.id_incidente = ir.id_incidente\n" +
            "\tINNER JOIN recurso r ON ir.id_recurso = r.id_recurso\n" +
            "\tINNER JOIN incidente_recurso_estado ire ON ire.id_recurso = r.id_recurso AND ire.id_incidente = i.id_incidente\n" +
            "\tINNER JOIN recurso_estado re ON ire.id_recurso_estado = re.id_recurso_estado\n" +
            "WHERE i.id_incidente = ?1\n" +
            "GROUP BY r.id_tipo_recurso,\tr.id_recurso, r.nombre, ir.fecha_movilizacion, r.es_consulta_sanitaria,ir.id_codigo_finalizacion\n" +
            "ORDER BY ir.fecha_movilizacion ASC", nativeQuery = true)
    List<RecursoEstadoCompletoEntity> findRecursosIncidente(final Integer idIncidente);
}
