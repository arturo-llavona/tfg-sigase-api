package com.allavona.tfg.business.dto;

public class PlantillaClasificacionIncidenteDTO {
    private int idPlantillaClasificacionIncidente;
    private ClasificacionIncidenteDTO clasificacionIncidente;
    private TipoRecursoDTO tipoRecurso;
    private short orden;

    public int getIdPlantillaClasificacionIncidente() {
        return idPlantillaClasificacionIncidente;
    }

    public void setIdPlantillaClasificacionIncidente(int idPlantillaClasificacionIncidente) {
        this.idPlantillaClasificacionIncidente = idPlantillaClasificacionIncidente;
    }

    public ClasificacionIncidenteDTO getClasificacionIncidente() {
        return clasificacionIncidente;
    }

    public void setClasificacionIncidente(ClasificacionIncidenteDTO clasificacionIncidente) {
        this.clasificacionIncidente = clasificacionIncidente;
    }

    public TipoRecursoDTO getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecursoDTO tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }
}
