package com.allavona.tfg.business.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class ObservacionDTO {
    private Integer idObservacion;
    private Integer idIncidente;
    private UsuarioDTO usuario;
    private String texto;
    private Date fecha;
    private boolean datosMedicos;
}
