package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario implements Serializable {
    private Integer idUsuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String extension;
    private Integer tipoUsuario;
    private String username;
    private String password;
    private Boolean habilitado;

}
