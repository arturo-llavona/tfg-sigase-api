package com.allavona.tfg.business.dto;

import java.io.Serializable;

public class RecursoDTO implements Serializable {
    private int idRecurso;
    private TipoRecursoDTO tipoRecurso;
    private String nombre;
    private boolean esConsultaSanitaria;
    private boolean habilitado;

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public TipoRecursoDTO getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecursoDTO tipoRecurso) {
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
}
