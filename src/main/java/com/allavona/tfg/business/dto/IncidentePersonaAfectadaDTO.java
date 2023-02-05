package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter @Setter @Builder @ToString
public class IncidentePersonaAfectadaDTO {
    private int idIncidentePersonaAfectada;
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
