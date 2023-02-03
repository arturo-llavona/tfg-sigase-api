package com.allavona.tfg.business.dto;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;


public class IncidenteDTO {

    private int idIncidente;

    private Object fechaCreacion;

    private Object fechaFinalizacion;

    private String alertante;

    private String alias;

    private String localizacionDescripcion;

    private BigDecimal localizacionLongitud;

    private BigDecimal localizacionLatitud;

    private ClasificacionIncidenteDTO clasificacionIncidente;

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public Object getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Object fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Object getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Object fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getAlertante() {
        return alertante;
    }

    public void setAlertante(String alertante) {
        this.alertante = alertante;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLocalizacionDescripcion() {
        return localizacionDescripcion;
    }

    public void setLocalizacionDescripcion(String localizacionDescripcion) {
        this.localizacionDescripcion = localizacionDescripcion;
    }

    public BigDecimal getLocalizacionLongitud() {
        return localizacionLongitud;
    }

    public void setLocalizacionLongitud(BigDecimal localizacionLongitud) {
        this.localizacionLongitud = localizacionLongitud;
    }

    public BigDecimal getLocalizacionLatitud() {
        return localizacionLatitud;
    }

    public void setLocalizacionLatitud(BigDecimal localizacionLatitud) {
        this.localizacionLatitud = localizacionLatitud;
    }

    public ClasificacionIncidenteDTO getClasificacionIncidente() {
        return clasificacionIncidente;
    }

    public void setClasificacionIncidente(ClasificacionIncidenteDTO clasificacionIncidente) {
        this.clasificacionIncidente = clasificacionIncidente;
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
