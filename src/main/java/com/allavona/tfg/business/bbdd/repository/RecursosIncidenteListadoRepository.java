package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.RecursoEstadoCompletoEntity;
import com.allavona.tfg.business.bbdd.entity.RecursoIncidenteListadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecursosIncidenteListadoRepository extends JpaRepository<RecursoIncidenteListadoEntity, Integer>  {
    @Query(value = "SELECT\n" +
            "\tb.id_tipo_recurso,\n" +
            "\tb.id_recurso,\n" +
            "\tb.nombre_recurso,\n" +
            "\tb.id_codigo_finalizacion,\n" +
            "\tb.fecha_movilizacion,\n" +
            "\tb.fecha_estado,\n" +
            "\td.nombre_estado\n" +
            "FROM \n" +
            "\t(\n" +
            "\t\tSELECT\n" +
            "\t\t\ti.id_incidente,\n" +
            "\t\t\tr.id_tipo_recurso,\n" +
            "\t\t\tr.id_recurso,\n" +
            "\t\t\tr.nombre as nombre_recurso,\n" +
            "\t\t\tir.id_codigo_finalizacion,\n" +
            "\t\t\tir.fecha_movilizacion,\n" +
            "\t\t\tmax(ire.fecha) as fecha_estado,\n" +
            "\t\t\tmax(ire.id_incidente_recurso_estado) as id_incidente_recurso_estado\n" +
            "\t\tFROM incidente i\n" +
            "\t\t\tINNER JOIN incidente_recurso ir ON i.id_incidente = ir.id_incidente\n" +
            "\t\t\tINNER JOIN recurso r ON ir.id_recurso = r.id_recurso\n" +
            "\t\t\tINNER JOIN incidente_recurso_estado ire ON ire.id_recurso = r.id_recurso AND ire.id_incidente = i.id_incidente\n" +
            "\t\t\tINNER JOIN recurso_estado re ON ire.id_recurso_estado = re.id_recurso_estado\n" +
            "\t\tWHERE i.id_incidente = ?1\n" +
            "\t\tGROUP BY i.id_incidente, r.id_tipo_recurso,\tr.id_recurso, r.nombre, ir.fecha_movilizacion,ir.id_codigo_finalizacion\n" +
            "\t\tORDER BY ir.fecha_movilizacion ASC\n" +
            "\t) b \n" +
            "INNER JOIN incidente_recurso_estado c ON b.id_incidente_recurso_estado = c.id_incidente_recurso_estado\n" +
            "INNER JOIN recurso_estado d ON c.id_recurso_estado = d.id_recurso_estado", nativeQuery = true)
    List<RecursoIncidenteListadoEntity> findRecursosIncidente(final Integer idIncidente);
}
