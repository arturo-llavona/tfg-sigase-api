package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipo_recurso", schema = "public", catalog = "tfg")
public class TipoRecursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_recurso")
    private int idTipoRecurso;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "habilitado")
    private boolean habilitado;

    public int getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(int idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoRecursoEntity that = (TipoRecursoEntity) o;
        return idTipoRecurso == that.idTipoRecurso && habilitado == that.habilitado && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoRecurso, nombre, habilitado);
    }
}
