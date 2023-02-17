package com.allavona.tfg.api.vo;

import com.allavona.tfg.business.dto.EstadoRecursoDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recurso implements Serializable {
    private Integer idRecurso;
    private TipoRecurso tipoRecurso;
    private EstadoRecurso estado;
    private String nombre;
    private boolean habilitado;
}
