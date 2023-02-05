package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class ClasificacionIncidenteDTO {
    private Integer idClasificacionIncidente;
    private String codigo;
    private String nombre;

}
