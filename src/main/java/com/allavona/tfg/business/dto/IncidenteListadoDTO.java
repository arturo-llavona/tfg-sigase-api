package com.allavona.tfg.business.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

public class IncidenteListadoDTO {
    private Integer idIncidente;
    private String alias;
    private String localizacionLongitud;
    private String localizacionLatitud;
    private Date fechaFinalizacion;
    private List<RecursoIncidenteListadoDTO> recursos;

    public Integer getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Integer idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLocalizacionLongitud() {
        return localizacionLongitud;
    }

    public void setLocalizacionLongitud(String localizacionLongitud) {
        this.localizacionLongitud = localizacionLongitud;
    }

    public String getLocalizacionLatitud() {
        return localizacionLatitud;
    }

    public void setLocalizacionLatitud(String localizacionLatitud) {
        this.localizacionLatitud = localizacionLatitud;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public List<RecursoIncidenteListadoDTO> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoIncidenteListadoDTO> recursos) {
        this.recursos = recursos;
    }
}
