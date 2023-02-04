package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.base.UsuarioEntity;
import com.allavona.tfg.business.bbdd.repository.base.UsuarioRepository;
import com.allavona.tfg.business.converter.UsuarioEntityConverter;
import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.UsuariosService;
import com.allavona.tfg.business.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuarioRepository repository;

    private UsuarioEntityConverter converter = new UsuarioEntityConverter();

    @Override
    public UsuarioDTO autenticar(UsuarioDTO usuario) {
        UsuarioEntity source = repository.autenticar(usuario.getUsername(), EncryptUtils.encrypt(usuario.getPassword()));
        UsuarioDTO resp = Optional.ofNullable(source).map(t-> converter.convert(t)).orElse(null);
        if ( resp != null ) {
            resp.setPassword(null);
        }
        return resp;
    }
}
