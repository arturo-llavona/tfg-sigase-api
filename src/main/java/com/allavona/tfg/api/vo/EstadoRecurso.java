package com.allavona.tfg.api.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EstadoRecurso {
    private Integer idRecursoEstado;
    private String nombreEstado;
    private Date fechaEstado;
}
