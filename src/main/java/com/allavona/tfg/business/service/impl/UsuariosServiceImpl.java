package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.api.dto.LoginDTO;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.bbdd.repository.UsuarioRepository;
import com.allavona.tfg.business.service.UsuariosService;
import com.allavona.tfg.business.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity autenticar(LoginDTO usuario) {
        return usuarioRepository.autenticar(usuario.getUsername(), EncryptUtils.encrypt(usuario.getPassword()));
    }
}
