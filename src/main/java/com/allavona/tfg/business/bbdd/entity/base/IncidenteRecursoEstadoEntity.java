package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "incidente_recurso_estado", schema = "public", catalog = "tfg")
public class IncidenteRecursoEstadoEntity {
    @Basic
    @Column(name = "id_recurso")
    private int idRecurso;
    @Basic
    @Column(name = "id_incidente")
    private int idIncidente;
    @Basic
    @Column(name = "id_recurso_estado")
    private int idRecursoEstado;
    @Basic
    @Column(name = "fecha")
    private Object fecha;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_incidente_recurso_estado")
    private int idIncidenteRecursoEstado;

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public int getIdRecursoEstado() {
        return idRecursoEstado;
    }

    public void setIdRecursoEstado(int idRecursoEstado) {
        this.idRecursoEstado = idRecursoEstado;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    public int getIdIncidenteRecursoEstado() {
        return idIncidenteRecursoEstado;
    }

    public void setIdIncidenteRecursoEstado(int idIncidenteRecursoEstado) {
        this.idIncidenteRecursoEstado = idIncidenteRecursoEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidenteRecursoEstadoEntity that = (IncidenteRecursoEstadoEntity) o;
        return idRecurso == that.idRecurso && idIncidente == that.idIncidente && idRecursoEstado == that.idRecursoEstado && idIncidenteRecursoEstado == that.idIncidenteRecursoEstado && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecurso, idIncidente, idRecursoEstado, fecha, idIncidenteRecursoEstado);
    }
}
