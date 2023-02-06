package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recurso_estado", schema = "public", catalog = "tfg")
@NoArgsConstructor
@Data
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
