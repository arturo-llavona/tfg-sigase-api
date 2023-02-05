package com.allavona.tfg.business.dto;

import java.util.Date;

public class RecursoEstadoCompletoDTO {
    private Integer idRecurso;
    private Integer idTipoRecurso;

    private String nombreRecurso;

    private Date fechaMovilizacion;

    private Integer idCodigoFinalizacion;

    private Integer idIncidenteRecursoEstado;

    private Boolean esConsultaSanitaria;

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

    public Integer getIdIncidenteRecursoEstado() {
        return idIncidenteRecursoEstado;
    }

    public void setIdIncidenteRecursoEstado(Integer idIncidenteRecursoEstado) {
        this.idIncidenteRecursoEstado = idIncidenteRecursoEstado;
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
