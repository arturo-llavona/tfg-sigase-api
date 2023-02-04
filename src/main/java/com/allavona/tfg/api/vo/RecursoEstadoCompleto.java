package com.allavona.tfg.api.vo;

import java.io.Serializable;
import java.util.Date;

public class RecursoEstadoCompleto implements Serializable {

    private String nombreRecurso;

    private Date fechaMovilizacion;

    private Integer idCodigoFinalizacion;

    private Boolean esConsultaSanitaria;

    private Date fechaEstado;

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public Date getFechaMovilizacion() {
        return fechaMovilizacion;
    }

    public void setFechaMovilizacion(Date fechaMovilizacion) {
        this.fechaMovilizacion = fechaMovilizacion;
    }

    public Integer getIdCodigoFinalizacion() {
        return idCodigoFinalizacion;
    }

    public void setIdCodigoFinalizacion(Integer idCodigoFinalizacion) {
        this.idCodigoFinalizacion = idCodigoFinalizacion;
    }

    public Boolean getEsConsultaSanitaria() {
        return esConsultaSanitaria;
    }

    public void setEsConsultaSanitaria(Boolean esConsultaSanitaria) {
        this.esConsultaSanitaria = esConsultaSanitaria;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }
}
