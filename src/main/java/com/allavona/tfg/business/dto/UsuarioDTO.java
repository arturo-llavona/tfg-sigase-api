package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class UsuarioDTO {
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
