package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {
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
