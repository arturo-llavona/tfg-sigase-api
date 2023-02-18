package com.allavona.tfg.business.dto;

import lombok.*;

@Data
@Builder
public class RecursoDTO {
    private Integer idRecurso;
    private TipoRecursoDTO tipoRecurso;
    private String nombre;
    private boolean habilitado;
    private EstadoRecursoDTO estado;

}
