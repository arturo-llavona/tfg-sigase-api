package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clasificacion_incidente", schema = "public", catalog = "tfg")
public class ClasificacionIncidenteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_clasificacion_incidente")
    private int idClasificacionIncidente;
    @Basic
    @Column(name = "codigo")
    private String codigo;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    public int getIdClasificacionIncidente() {
        return idClasificacionIncidente;
    }

    public void setIdClasificacionIncidente(int idClasificacionIncidente) {
        this.idClasificacionIncidente = idClasificacionIncidente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasificacionIncidenteEntity that = (ClasificacionIncidenteEntity) o;
        return idClasificacionIncidente == that.idClasificacionIncidente && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClasificacionIncidente, codigo, nombre);
    }
}
