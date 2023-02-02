package com.allavona.tfg.business.bbdd.entity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObservacionEntity that = (ObservacionEntity) o;
        return idObservacion == that.idObservacion && idIncidente == that.idIncidente && idUsuario == that.idUsuario && Objects.equals(texto, that.texto) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObservacion, idIncidente, idUsuario, texto, fecha);
    }
}
