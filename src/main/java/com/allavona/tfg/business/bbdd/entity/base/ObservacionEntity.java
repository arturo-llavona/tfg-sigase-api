package com.allavona.tfg.business.bbdd.entity.base;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "observacion", schema = "public", catalog = "tfg")
@Getter @Setter @EqualsAndHashCode
public class ObservacionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_observacion")
    private Integer idObservacion;
    @Basic
    @Column(name = "id_incidente")
    private Integer idIncidente;
    @Basic
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic
    @Column(name = "texto")
    private String texto;
    @Basic
    @Column(name = "fecha")
    private Date fecha;
    @Basic
    @Column(name = "datos_medicos")
    private boolean datosMedicos;
}
