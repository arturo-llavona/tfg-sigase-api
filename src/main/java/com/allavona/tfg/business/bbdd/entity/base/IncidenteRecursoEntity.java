package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "incidente_recurso", schema = "public", catalog = "tfg")
public class IncidenteRecursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_incidente_recurso")
    private int idIncidenteRecurso;
    @Basic
    @Column(name = "id_incidente")
    private int idIncidente;
    @Basic
    @Column(name = "id_recurso")
    private int idRecurso;
    @Basic
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic
    @Column(name = "id_codigo_finalizacion")
    private Integer idCodigoFinalizacion;
    @Basic
    @Column(name = "fecha_movilizacion")
    private Object fechaMovilizacion;

    public int getIdIncidenteRecurso() {
        return idIncidenteRecurso;
    }

    public void setIdIncidenteRecurso(int idIncidenteRecurso) {
        this.idIncidenteRecurso = idIncidenteRecurso;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCodigoFinalizacion() {
        return idCodigoFinalizacion;
    }

    public void setIdCodigoFinalizacion(Integer idCodigoFinalizacion) {
        this.idCodigoFinalizacion = idCodigoFinalizacion;
    }

    public Object getFechaMovilizacion() {
        return fechaMovilizacion;
    }

    public void setFechaMovilizacion(Object fechaMovilizacion) {
        this.fechaMovilizacion = fechaMovilizacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidenteRecursoEntity that = (IncidenteRecursoEntity) o;
        return idIncidenteRecurso == that.idIncidenteRecurso && idIncidente == that.idIncidente && idRecurso == that.idRecurso && idUsuario == that.idUsuario && Objects.equals(idCodigoFinalizacion, that.idCodigoFinalizacion) && Objects.equals(fechaMovilizacion, that.fechaMovilizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIncidenteRecurso, idIncidente, idRecurso, idUsuario, idCodigoFinalizacion, fechaMovilizacion);
    }
}
