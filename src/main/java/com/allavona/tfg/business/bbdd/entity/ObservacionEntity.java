package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "observacion", schema = "public", catalog = "tfg")
@NoArgsConstructor
@Data
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
