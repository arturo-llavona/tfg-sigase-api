package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.UsuarioDTO;

public interface UsuariosService {
    // Método que comprueba si existe un usuario en base de datos con username y password indicados.
    public UsuarioDTO autenticar(UsuarioDTO usuario);
    // Método que realiza una búsqueda de un usuario a partir de su username.
    public UsuarioDTO getUsuarioByUsername(String username);
}
