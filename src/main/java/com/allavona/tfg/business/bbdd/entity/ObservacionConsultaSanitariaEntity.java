package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "observacion_consulta_sanitaria", schema = "public", catalog = "tfg")
public class ObservacionConsultaSanitariaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_observacion_consulta_sanitaria")
    private int idObservacionConsultaSanitaria;
    @Basic
    @Column(name = "id_incidente_recurso")
    private int idIncidenteRecurso;
    @Basic
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic
    @Column(name = "texto")
    private String texto;
    @Basic
    @Column(name = "fecha")
    private Object fecha;

    public int getIdObservacionConsultaSanitaria() {
        return idObservacionConsultaSanitaria;
    }

    public void setIdObservacionConsultaSanitaria(int idObservacionConsultaSanitaria) {
        this.idObservacionConsultaSanitaria = idObservacionConsultaSanitaria;
    }

    public int getIdIncidenteRecurso() {
        return idIncidenteRecurso;
    }

    public void setIdIncidenteRecurso(int idIncidenteRecurso) {
        this.idIncidenteRecurso = idIncidenteRecurso;
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
        ObservacionConsultaSanitariaEntity that = (ObservacionConsultaSanitariaEntity) o;
        return idObservacionConsultaSanitaria == that.idObservacionConsultaSanitaria && idIncidenteRecurso == that.idIncidenteRecurso && idUsuario == that.idUsuario && Objects.equals(texto, that.texto) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObservacionConsultaSanitaria, idIncidenteRecurso, idUsuario, texto, fecha);
    }
}
