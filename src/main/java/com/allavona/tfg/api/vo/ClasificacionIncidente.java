package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClasificacionIncidente implements Serializable {
    private int idClasificacionIncidente;
    private String codigo;
    private String nombre;
}
