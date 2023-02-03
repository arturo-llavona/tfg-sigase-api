package com.allavona.tfg.business.dto;

public class ClasificacionIncidenteDTO {
    private int idClasificacionIncidente;
    private String codigo;
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
}
