package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClasificacionIncidente implements Serializable {
    private Integer idClasificacionIncidente;
    private String codigo;
    private String nombre;
}
