package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "incidente_recurso_estado", schema = "public", catalog = "tfg")
@Getter @Setter @EqualsAndHashCode
public class IncidenteRecursoEstadoEntity {
    @Basic
    @Column(name = "id_recurso")
    private int idRecurso;
    @Basic
    @Column(name = "id_incidente")
    private int idIncidente;
    @Basic
    @Column(name = "id_recurso_estado")
    private int idRecursoEstado;
    @Basic
    @Column(name = "fecha")
    private Date fecha;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_incidente_recurso_estado")
    private int idIncidenteRecursoEstado;
}
