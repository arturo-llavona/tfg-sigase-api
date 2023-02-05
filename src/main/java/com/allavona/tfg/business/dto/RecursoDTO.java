package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class RecursoDTO {
    private int idRecurso;
    private TipoRecursoDTO tipoRecurso;
    private String nombre;
    private boolean esConsultaSanitaria;
    private boolean habilitado;
    private EstadoRecursoDTO estado;

}
