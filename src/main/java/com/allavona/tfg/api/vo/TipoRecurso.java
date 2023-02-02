package com.allavona.tfg.api.vo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;

import java.io.Serializable;

public class TipoRecurso implements Serializable {

    private int idTipoRecurso;
    private String nombre;
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
}
