package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "incidente_recurso", schema = "public", catalog = "tfg")
@Setter
@Getter
@EqualsAndHashCode
public class IncidenteRecursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_incidente_recurso")
    private int idIncidenteRecurso;
    @Basic
    @Column(name = "id_incidente")
    private int idIncidente;
    @Basic
    @Column(name = "id_recurso")
    private int idRecurso;
    @Basic
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic
    @Column(name = "id_codigo_finalizacion")
    private Integer idCodigoFinalizacion;
    @Basic
    @Column(name = "fecha_movilizacion")
    private Object fechaMovilizacion;
}
