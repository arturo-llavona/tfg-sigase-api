package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tipo_recurso", schema = "public", catalog = "tfg")
@Getter @Setter @EqualsAndHashCode
public class TipoRecursoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_recurso")
    private int idTipoRecurso;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "habilitado")
    private boolean habilitado;
    @OneToMany(mappedBy="tipoRecurso", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<RecursoEntity> recursos;
}
