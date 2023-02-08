package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.UsuarioDTO;

public interface UsuariosService {
    public UsuarioDTO autenticar(UsuarioDTO usuario);

    public UsuarioDTO getUsuarioByUsername(String username);
}
