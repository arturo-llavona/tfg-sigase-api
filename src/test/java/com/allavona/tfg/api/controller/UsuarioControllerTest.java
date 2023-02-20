package com.allavona.tfg.api.controller;

import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.UsuariosService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UsuarioControllerTest {
    @Autowired
    private UsuariosService usuariosService;

    @Test
    @DisplayName("Autenticar usuario")
    void autenticar() {
        UsuarioDTO usuario = UsuarioDTO.builder().build();
        usuario.setUsername("medico");
        usuario.setPassword("arturo");
        usuario = usuariosService.autenticar(usuario);
        assertNotNull(usuario);
    }
}