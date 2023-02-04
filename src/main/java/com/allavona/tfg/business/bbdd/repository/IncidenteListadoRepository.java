package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.IncidenteListadoEntity;
import com.allavona.tfg.business.bbdd.entity.RecursoEstadoCompletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncidenteListadoRepository extends JpaRepository<IncidenteListadoEntity, Integer> {

    @Query(value = "SELECT\n" +
            "\t\t\tid_incidente,\n" +
            "\t\t\talias,\n" +
            "\t\t\tlocalizacion_longitud,\n" +
            "\t\t\tlocalizacion_latitud,\n" +
            "\t\t\tfecha_finalizacion\n" +
            "\t\tFROM incidente i\n" +
            "\t\tWHERE fecha_finalizacion IS NULL", nativeQuery = true)
    List<IncidenteListadoEntity> findIncidenteEnCursoListado();

    @Query(value = "SELECT\n" +
            "\t\t\tid_incidente,\n" +
            "\t\t\talias,\n" +
            "\t\t\tlocalizacion_longitud,\n" +
            "\t\t\tlocalizacion_latitud,\n" +
            "\t\t\tfecha_finalizacion\n" +
            "\t\tFROM incidente i\n" +
            "\t\tWHERE fecha_finalizacion IS NOT NULL", nativeQuery = true)
    List<IncidenteListadoEntity> findIncidenteFinalizadoListado();
}
