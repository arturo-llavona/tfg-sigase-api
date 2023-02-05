package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString @Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Observacion {
    private Integer idObservacion;
    private Integer idIncidente;
    private Usuario usuario;
    private String texto;
    private Date fecha;
    private boolean datosMedicos;
}
