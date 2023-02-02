package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "incidente_persona_afectada", schema = "public", catalog = "tfg")
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

    public int getIdIncidentePersonaAfectada() {
        return idIncidentePersonaAfectada;
    }

    public void setIdIncidentePersonaAfectada(int idIncidentePersonaAfectada) {
        this.idIncidentePersonaAfectada = idIncidentePersonaAfectada;
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public Short getTipoEdad() {
        return tipoEdad;
    }

    public void setTipoEdad(Short tipoEdad) {
        this.tipoEdad = tipoEdad;
    }

    public Short getSexo() {
        return sexo;
    }

    public void setSexo(Short sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCentroSalud() {
        return centroSalud;
    }

    public void setCentroSalud(String centroSalud) {
        this.centroSalud = centroSalud;
    }

    public String getTarjetaSanitaria() {
        return tarjetaSanitaria;
    }

    public void setTarjetaSanitaria(String tarjetaSanitaria) {
        this.tarjetaSanitaria = tarjetaSanitaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidentePersonaAfectadaEntity that = (IncidentePersonaAfectadaEntity) o;
        return idIncidentePersonaAfectada == that.idIncidentePersonaAfectada && idIncidente == that.idIncidente && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(edad, that.edad) && Objects.equals(tipoEdad, that.tipoEdad) && Objects.equals(sexo, that.sexo) && Objects.equals(dni, that.dni) && Objects.equals(telefono, that.telefono) && Objects.equals(centroSalud, that.centroSalud) && Objects.equals(tarjetaSanitaria, that.tarjetaSanitaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIncidentePersonaAfectada, idIncidente, fechaNacimiento, nombre, apellidos, edad, tipoEdad, sexo, dni, telefono, centroSalud, tarjetaSanitaria);
    }
}
