package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;

@Entity
@Table(name = "plantilla_clasificacion_incidente", schema = "public", catalog = "tfg")
public class PlantillaClasificacionIncidenteEntity {
    @ManyToOne()
    @JoinColumn(name = "id_clasificacion_incidente")
    private ClasificacionIncidenteEntity clasificacionIncidente;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_recurso")
    private TipoRecursoEntity tipoRecurso;

    @Basic
    @Column(name = "orden")
    private short orden;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_plantilla_clasificacion_incidente")
    private int idPlantillaClasificacionIncidente;

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public int getIdPlantillaClasificacionIncidente() {
        return idPlantillaClasificacionIncidente;
    }

    public void setIdPlantillaClasificacionIncidente(int idPlantillaClasificacionIncidente) {
        this.idPlantillaClasificacionIncidente = idPlantillaClasificacionIncidente;
    }

    public ClasificacionIncidenteEntity getClasificacionIncidente() {
        return clasificacionIncidente;
    }

    public void setClasificacionIncidente(ClasificacionIncidenteEntity clasificacionIncidente) {
        this.clasificacionIncidente = clasificacionIncidente;
    }

    public TipoRecursoEntity getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecursoEntity tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
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
