package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString
public class TipoRecursoDTO {
    private int idTipoRecurso;
    private String nombre;
    private boolean habilitado;
}
