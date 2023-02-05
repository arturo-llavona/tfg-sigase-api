package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "incidente_persona_afectada", schema = "public", catalog = "tfg")
@Getter @Setter @EqualsAndHashCode
public class IncidentePersonaAfectadaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_incidente_persona_afectada")
    private int idIncidentePersonaAfectada;
    @Basic
    @Column(name = "id_incidente")
    private int idIncidente;
    @Basic
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellidos")
    private String apellidos;
    @Basic
    @Column(name = "edad")
    private Short edad;
    @Basic
    @Column(name = "tipo_edad")
    private Short tipoEdad;
    @Basic
    @Column(name = "sexo")
    private Short sexo;
    @Basic
    @Column(name = "dni")
    private String dni;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "centro_salud")
    private String centroSalud;
    @Basic
    @Column(name = "tarjeta_sanitaria")
    private String tarjetaSanitaria;

}
