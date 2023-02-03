package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recurso", schema = "public", catalog = "tfg")
public class RecursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_recurso")
    private int idRecurso;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_recurso")
    private TipoRecursoEntity tipoRecurso;
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

    public TipoRecursoEntity getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecursoEntity tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
