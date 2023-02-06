package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Observacion {
    private Integer idObservacion;
    private Integer idIncidente;
    private Usuario usuario;
    private String texto;
    private Date fecha;
    private boolean datosMedicos;
}
