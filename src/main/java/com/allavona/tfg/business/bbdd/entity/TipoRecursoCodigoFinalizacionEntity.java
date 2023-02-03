package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipo_recurso_codigo_finalizacion", schema = "public", catalog = "tfg")
public class TipoRecursoCodigoFinalizacionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_recurso")
    private int idTipoRecurso;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_codigo_finalizacion")
    private int idCodigoFinalizacion;
    @Basic
    @Column(name = "nombre")
    private String nombre;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoRecursoCodigoFinalizacionEntity that = (TipoRecursoCodigoFinalizacionEntity) o;
        return idTipoRecurso == that.idTipoRecurso && idCodigoFinalizacion == that.idCodigoFinalizacion && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoRecurso, idCodigoFinalizacion, nombre);
    }
}
