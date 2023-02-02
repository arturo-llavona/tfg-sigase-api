package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "recurso", schema = "public", catalog = "tfg")
public class RecursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_recurso")
    private int idRecurso;
    @Basic
    @Column(name = "id_tipo_recurso")
    private int idTipoRecurso;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "es_consulta_sanitaria")
    private boolean esConsultaSanitaria;
    @Basic
    @Column(name = "habilitado")
    private boolean habilitado;

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

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

    public boolean isEsConsultaSanitaria() {
        return esConsultaSanitaria;
    }

    public void setEsConsultaSanitaria(boolean esConsultaSanitaria) {
        this.esConsultaSanitaria = esConsultaSanitaria;
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
        RecursoEntity that = (RecursoEntity) o;
        return idRecurso == that.idRecurso && idTipoRecurso == that.idTipoRecurso && esConsultaSanitaria == that.esConsultaSanitaria && habilitado == that.habilitado && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecurso, idTipoRecurso, nombre, esConsultaSanitaria, habilitado);
    }
}
