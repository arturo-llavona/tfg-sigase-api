package com.allavona.tfg.api.vo;

import com.allavona.tfg.business.dto.RecursoIncidenteListadoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class IncidenteListado implements Serializable {
    private Integer idIncidente;
    private String alias;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String localizacionLongitud;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String localizacionLatitud;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date fechaFinalizacion;
    private List<RecursoIncidenteListado> recursos;

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

    public List<RecursoIncidenteListado> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoIncidenteListado> recursos) {
        this.recursos = recursos;
    }
}
