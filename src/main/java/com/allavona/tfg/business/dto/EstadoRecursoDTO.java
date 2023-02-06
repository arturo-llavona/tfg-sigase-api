package com.allavona.tfg.business.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class EstadoRecursoDTO {
    private Integer idRecursoEstado;
    private String nombreEstado;
    private Date fechaEstado;
}
