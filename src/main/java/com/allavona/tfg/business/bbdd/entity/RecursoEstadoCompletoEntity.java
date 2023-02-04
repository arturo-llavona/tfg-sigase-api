package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class RecursoEstadoCompletoEntity {
    @Id
    @Column(name = "id_recurso")
    private Integer idRecurso;

    @Column(name = "id_tipo_recurso")
    private Integer idTipoRecurso;

    @Column(name = "nombre_recurso")
    private String nombreRecurso;

    @Column(name = "fecha_movilizacion")
    private Date fechaMovilizacion;

    @Column(name = "id_codigo_finalizacion")
    private Integer idCodigoFinalizacion;

    @Column(name = "id_incidente_recurso_estado")
    private Integer idIncidenteRecursoEstado;

    @Column(name = "es_consulta_sanitaria")
    private Boolean esConsultaSanitaria;

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
