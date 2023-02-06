package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recurso implements Serializable {
    private Integer idRecurso;
    private TipoRecurso tipoRecurso;
    private String nombre;
    private boolean esConsultaSanitaria;
    private boolean habilitado;
}
