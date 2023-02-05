package com.allavona.tfg.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario implements Serializable {
    private int idUsuario;
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
