package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy="tipoRecurso", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<RecursoEntity> recursos;

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

    public List<RecursoEntity> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoEntity> recursos) {
        this.recursos = recursos;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
