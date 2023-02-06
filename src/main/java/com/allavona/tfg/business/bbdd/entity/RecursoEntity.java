package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recurso", schema = "public", catalog = "tfg")
@NoArgsConstructor
@Data
public class RecursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_recurso")
    private int idRecurso;

    @ManyToOne()
    @JoinColumn(name = "id_tipo_recurso")
    private TipoRecursoEntity tipoRecurso;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "habilitado")
    private boolean habilitado;
}
