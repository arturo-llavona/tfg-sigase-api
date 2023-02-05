package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "plantilla_clasificacion_incidente", schema = "public", catalog = "tfg")
@Setter
@Getter
@EqualsAndHashCode
public class PlantillaClasificacionIncidenteEntity {
    @Basic
    @Column(name = "id_clasificacion_incidente", nullable = false)
    private Integer idClasificacionIncidente;
    @Basic
    @Column(name = "id_tipo_recurso", nullable = false)
    private Integer idTipoRecurso;
    @Basic
    @Column(name = "orden", nullable = false)
    private Short orden;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_plantilla_clasificacion_incidente", nullable = false)
    private Integer idPlantillaClasificacionIncidente;
}
