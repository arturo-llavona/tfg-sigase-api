package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "observacion", schema = "public", catalog = "tfg")
public class ObservacionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_observacion")
    private int idObservacion;
    @Basic
    @Column(name = "id_incidente")
    private int idIncidente;
    @Basic
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic
    @Column(name = "texto")
    private String texto;
    @Basic
    @Column(name = "fecha")
    private Object fecha;

    @Basic
    @Column(name = "datos_medicos")
    private boolean datosMedicos;

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    public boolean isDatosMedicos() {
        return datosMedicos;
    }

    public void setDatosMedicos(boolean datosMedicos) {
        this.datosMedicos = datosMedicos;
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
