package com.allavona.tfg.business.service;

import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.dto.UsuarioDTO;

public interface UsuariosService {
    public UsuarioDTO autenticar(Login usuario);
}
