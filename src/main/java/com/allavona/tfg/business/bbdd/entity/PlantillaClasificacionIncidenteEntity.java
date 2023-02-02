package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "plantilla_clasificacion_incidente", schema = "public", catalog = "tfg")
public class PlantillaClasificacionIncidenteEntity {
    @Basic
    @Column(name = "id_clasificacion_incidente")
    private int idClasificacionIncidente;
    @Basic
    @Column(name = "id_tipo_recurso")
    private int idTipoRecurso;
    @Basic
    @Column(name = "orden")
    private short orden;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_plantilla_clasificacion_incidente")
    private int idPlantillaClasificacionIncidente;

    public int getIdClasificacionIncidente() {
        return idClasificacionIncidente;
    }

    public void setIdClasificacionIncidente(int idClasificacionIncidente) {
        this.idClasificacionIncidente = idClasificacionIncidente;
    }

    public int getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(int idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public int getIdPlantillaClasificacionIncidente() {
        return idPlantillaClasificacionIncidente;
    }

    public void setIdPlantillaClasificacionIncidente(int idPlantillaClasificacionIncidente) {
        this.idPlantillaClasificacionIncidente = idPlantillaClasificacionIncidente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantillaClasificacionIncidenteEntity that = (PlantillaClasificacionIncidenteEntity) o;
        return idClasificacionIncidente == that.idClasificacionIncidente && idTipoRecurso == that.idTipoRecurso && orden == that.orden && idPlantillaClasificacionIncidente == that.idPlantillaClasificacionIncidente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClasificacionIncidente, idTipoRecurso, orden, idPlantillaClasificacionIncidente);
    }
}
