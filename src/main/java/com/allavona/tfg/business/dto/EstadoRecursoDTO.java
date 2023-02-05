package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString @Builder
public class EstadoRecursoDTO {
    private Integer idRecursoEstado;
    private String nombreEstado;
    private Date fechaEstado;
}
