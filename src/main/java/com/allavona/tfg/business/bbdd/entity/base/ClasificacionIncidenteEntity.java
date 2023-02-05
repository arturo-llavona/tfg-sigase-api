package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clasificacion_incidente", schema = "public", catalog = "tfg")
@Getter @Setter @EqualsAndHashCode
public class ClasificacionIncidenteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_clasificacion_incidente")
    private int idClasificacionIncidente;
    @Basic
    @Column(name = "codigo")
    private String codigo;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy="clasificacionIncidente", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<IncidenteEntity> incidentes;
}
