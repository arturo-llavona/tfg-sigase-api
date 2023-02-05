package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_recurso_codigo_finalizacion", schema = "public", catalog = "tfg")
@Setter
@Getter
@EqualsAndHashCode
public class TipoRecursoCodigoFinalizacionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_recurso")
    private int idTipoRecurso;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_codigo_finalizacion")
    private int idCodigoFinalizacion;
    @Basic
    @Column(name = "nombre")
    private String nombre;
}
