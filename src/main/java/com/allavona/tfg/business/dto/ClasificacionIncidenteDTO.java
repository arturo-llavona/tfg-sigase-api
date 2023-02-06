package com.allavona.tfg.business.dto;

import lombok.*;

@Data
@Builder
public class ClasificacionIncidenteDTO {
    private Integer idClasificacionIncidente;
    private String codigo;
    private String nombre;

}
