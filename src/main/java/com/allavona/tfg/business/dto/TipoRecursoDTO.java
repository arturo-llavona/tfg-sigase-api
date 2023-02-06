package com.allavona.tfg.business.dto;

import lombok.*;

@Data
@Builder
public class TipoRecursoDTO {
    private Integer idTipoRecurso;
    private String nombre;
    private Boolean habilitado;
}
