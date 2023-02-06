package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoRecurso implements Serializable {
    private Integer idTipoRecurso;
    private String nombre;
    private Boolean habilitado;
}
