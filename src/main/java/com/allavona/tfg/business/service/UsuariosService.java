package com.allavona.tfg.business.service;

import com.allavona.tfg.api.dto.LoginDTO;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;

public interface UsuariosService {
    public UsuarioEntity autenticar(LoginDTO usuario);
}
