package com.allavona.tfg.business.service;

import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;

public interface UsuariosService {
    public Usuario autenticar(Login usuario);
}
