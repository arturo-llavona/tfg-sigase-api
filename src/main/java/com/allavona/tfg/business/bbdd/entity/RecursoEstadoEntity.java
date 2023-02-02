package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "recurso_estado", schema = "public", catalog = "tfg")
public class RecursoEstadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_recurso_estado")
    private int idRecursoEstado;
    @Basic
    @Column(name = "id_tipo_recurso")
    private int idTipoRecurso;
    @Basic
    @Column(name = "orden")
    private short orden;
    @Basic
    @Column(name = "nombre_estado")
    private String nombreEstado;

    public int getIdRecursoEstado() {
        return idRecursoEstado;
    }

    public void setIdRecursoEstado(int idRecursoEstado) {
        this.idRecursoEstado = idRecursoEstado;
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

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoEstadoEntity that = (RecursoEstadoEntity) o;
        return idRecursoEstado == that.idRecursoEstado && idTipoRecurso == that.idTipoRecurso && orden == that.orden && Objects.equals(nombreEstado, that.nombreEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecursoEstado, idTipoRecurso, orden, nombreEstado);
    }
}
