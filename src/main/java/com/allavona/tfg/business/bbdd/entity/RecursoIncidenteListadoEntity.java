package com.allavona.tfg.business.bbdd.entity;

import com.allavona.tfg.business.bbdd.entity.base.RecursoEntity;
import com.allavona.tfg.business.bbdd.entity.base.TipoRecursoEntity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class RecursoIncidenteListadoEntity {
    @Id
    @Column(name = "id_recurso")
    private Integer idRecurso;

    @Column(name = "id_tipo_recurso")
    private Integer idTipoRecurso;

    @Column(name = "nombre_recurso")
    private String nombreRecurso;

    @Column(name = "id_codigo_finalizacion")
    private Integer idCodigoFinalizacion;

    @Column(name = "fecha_movilizacion")
    private Date fechaMovilizacion;

    @Column(name = "nombre_estado")
    private String nombreEstado;

    @Column(name = "fecha_estado")
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

}
