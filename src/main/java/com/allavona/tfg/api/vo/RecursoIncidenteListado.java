package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

public class RecursoIncidenteListado implements Serializable {

    private Integer idRecurso;

    private Integer idTipoRecurso;

    private String nombreRecurso;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idCodigoFinalizacion;

    private Date fechaMovilizacion;

    private String nombreEstado;

    private Date fechaEstado;

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Integer getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(Integer idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public Integer getIdCodigoFinalizacion() {
        return idCodigoFinalizacion;
    }

    public void setIdCodigoFinalizacion(Integer idCodigoFinalizacion) {
        this.idCodigoFinalizacion = idCodigoFinalizacion;
    }

    public Date getFechaMovilizacion() {
        return fechaMovilizacion;
    }

    public void setFechaMovilizacion(Date fechaMovilizacion) {
        this.fechaMovilizacion = fechaMovilizacion;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
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
