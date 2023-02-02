package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.api.converter.UsuarioDtoConverter;
import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.bbdd.repository.UsuarioRepository;
import com.allavona.tfg.business.service.UsuariosService;
import com.allavona.tfg.business.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;

public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioDtoConverter usuarioDtoConverter = new UsuarioDtoConverter();

    @Override
    public Usuario autenticar(Login usuario) {
        UsuarioEntity source = usuarioRepository.autenticar(usuario.getUsername(), EncryptUtils.encrypt(usuario.getPassword()));
        Usuario resp = Optional.ofNullable(source).map(t-> usuarioDtoConverter.convert(t)).orElse(null);
        if ( resp != null ) {
            resp.setPassword(null);
        }
        return resp;
    }
}
