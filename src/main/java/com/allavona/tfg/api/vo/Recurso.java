package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter @Setter @Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recurso implements Serializable {
    private int idRecurso;
    private TipoRecurso tipoRecurso;
    private String nombre;
    private boolean esConsultaSanitaria;
    private boolean habilitado;
}
