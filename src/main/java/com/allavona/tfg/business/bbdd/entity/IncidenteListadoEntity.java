package com.allavona.tfg.business.bbdd.entity;

import com.allavona.tfg.business.bbdd.entity.base.RecursoEntity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class IncidenteListadoEntity {
    @Id
    @Column(name = "id_incidente")
    private Integer idIncidente;

    @Column(name = "alias")
    private String alias;

    @Column(name = "localizacion_longitud")
    private String localizacionLongitud;

    @Column(name = "localizacion_latitud")
    private String localizacionLatitud;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;


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
}
