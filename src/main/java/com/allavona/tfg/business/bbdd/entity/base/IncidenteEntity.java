package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "incidente", schema = "public", catalog = "tfg")
public class IncidenteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_incidente")
    private int idIncidente;
    @Basic
    @Column(name = "fecha_creacion")
    private Object fechaCreacion;
    @Basic
    @Column(name = "fecha_finalizacion")
    private Object fechaFinalizacion;
    @Basic
    @Column(name = "alertante")
    private String alertante;
    @Basic
    @Column(name = "alias")
    private String alias;
    @Basic
    @Column(name = "localizacion_descripcion")
    private String localizacionDescripcion;
    @Basic
    @Column(name = "localizacion_longitud")
    private BigDecimal localizacionLongitud;
    @Basic
    @Column(name = "localizacion_latitud")
    private BigDecimal localizacionLatitud;

    @ManyToOne()
    @JoinColumn(name = "id_clasificacion_incidente")
    private ClasificacionIncidenteEntity clasificacionIncidente;

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

    public ClasificacionIncidenteEntity getClasificacionIncidente() {
        return clasificacionIncidente;
    }

    public void setClasificacionIncidente(ClasificacionIncidenteEntity clasificacionIncidente) {
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
