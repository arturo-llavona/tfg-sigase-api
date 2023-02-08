package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.bbdd.repository.UsuarioRepository;
import com.allavona.tfg.business.converter.UsuarioEntityConverter;
import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.UsuariosService;
import com.allavona.tfg.business.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    private final UsuarioRepository repository;

    private UsuarioEntityConverter converter = new UsuarioEntityConverter();

    public UsuariosServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsuarioDTO autenticar(UsuarioDTO usuario) {
        UsuarioEntity source = repository.autenticar(usuario.getUsername(), EncryptUtils.encrypt(usuario.getPassword()));
        UsuarioDTO resp = Optional.ofNullable(source).map(t-> converter.convert(t)).orElse(null);
        if ( resp != null ) {
            resp.setPassword(null);
        }
        return resp;
    }

    @Override
    public UsuarioDTO getUsuarioByUsername(String username) {
        UsuarioEntity usuarioEntity = repository.findByUsername(username);
        return Optional.ofNullable(usuarioEntity).map(t -> {
            UsuarioDTO usuario = converter.convert(t);
            usuario.setPassword(null);
            return usuario;
        }).orElse(null);
    }
}
