package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "incidente", schema = "public", catalog = "tfg")
@Getter @Setter @EqualsAndHashCode
public class IncidenteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_incidente")
    private int idIncidente;
    @Basic
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Basic
    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;
    @Basic
    @Column(name = "alertante")
    private String alertante;
    @Basic
    @Column(name = "alias")
    private String alias;
    @Basic
    @Column(name = "localizacion_descripcion")
    private String localizacionDescripcion;
    @Basic
    @Column(name = "localizacion_longitud")
    private BigDecimal localizacionLongitud;
    @Basic
    @Column(name = "localizacion_latitud")
    private BigDecimal localizacionLatitud;

    @ManyToOne()
    @JoinColumn(name = "id_clasificacion_incidente")
    private ClasificacionIncidenteEntity clasificacionIncidente;
}
