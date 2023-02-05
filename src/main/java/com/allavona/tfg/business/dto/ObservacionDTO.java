package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString @Builder
public class ObservacionDTO {
    private Integer idObservacion;
    private Integer idIncidente;
    private UsuarioDTO usuario;
    private String texto;
    private Date fecha;
    private boolean datosMedicos;
}
