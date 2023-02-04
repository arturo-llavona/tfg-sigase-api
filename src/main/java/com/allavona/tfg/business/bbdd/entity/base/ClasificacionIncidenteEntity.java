package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy="clasificacionIncidente", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<IncidenteEntity> incidentes;

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

    public List<IncidenteEntity> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<IncidenteEntity> incidentes) {
        this.incidentes = incidentes;
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
