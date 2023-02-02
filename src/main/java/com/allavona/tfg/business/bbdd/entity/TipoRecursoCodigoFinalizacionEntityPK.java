package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class TipoRecursoCodigoFinalizacionEntityPK implements Serializable {
    @Column(name = "id_tipo_recurso")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoRecurso;
    @Column(name = "id_codigo_finalizacion")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCodigoFinalizacion;

    public int getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(int idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public int getIdCodigoFinalizacion() {
        return idCodigoFinalizacion;
    }

    public void setIdCodigoFinalizacion(int idCodigoFinalizacion) {
        this.idCodigoFinalizacion = idCodigoFinalizacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoRecursoCodigoFinalizacionEntityPK that = (TipoRecursoCodigoFinalizacionEntityPK) o;
        return idTipoRecurso == that.idTipoRecurso && idCodigoFinalizacion == that.idCodigoFinalizacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoRecurso, idCodigoFinalizacion);
    }
}
