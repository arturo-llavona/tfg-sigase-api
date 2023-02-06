package com.allavona.tfg.api.vo;

import lombok.*;

import java.sql.Date;

@Data
@Builder
public class IncidentePersonaAfectada {
    private Integer idIncidentePersonaAfectada;
    private Date fechaNacimiento;
    private String nombre;
    private String apellidos;
    private Short edad;
    private Short tipoEdad;
    private Short sexo;
    private String dni;
    private String telefono;
    private String centroSalud;
    private String tarjetaSanitaria;
}
