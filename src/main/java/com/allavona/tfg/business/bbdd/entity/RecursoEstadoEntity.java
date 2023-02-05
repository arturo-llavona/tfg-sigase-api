package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recurso_estado", schema = "public", catalog = "tfg")
@Setter @Getter @EqualsAndHashCode
public class RecursoEstadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_recurso_estado")
    private int idRecursoEstado;
    @Basic
    @Column(name = "id_tipo_recurso")
    private int idTipoRecurso;
    @Basic
    @Column(name = "orden")
    private short orden;
    @Basic
    @Column(name = "nombre_estado")
    private String nombreEstado;
}
