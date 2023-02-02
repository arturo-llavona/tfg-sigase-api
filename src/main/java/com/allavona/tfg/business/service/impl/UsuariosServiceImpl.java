package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.api.converter.UsuarioDtoConverter;
import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.bbdd.repository.UsuarioRepository;
import com.allavona.tfg.business.converter.UsuarioEntityConverter;
import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.UsuariosService;
import com.allavona.tfg.business.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;

public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioEntityConverter usuarioEntityConverter = new UsuarioEntityConverter();

    @Override
    public UsuarioDTO autenticar(UsuarioDTO usuario) {
        UsuarioEntity source = usuarioRepository.autenticar(usuario.getUsername(), EncryptUtils.encrypt(usuario.getPassword()));
        UsuarioDTO resp = Optional.ofNullable(source).map(t-> usuarioEntityConverter.convert(t)).orElse(null);
        if ( resp != null ) {
            resp.setPassword(null);
        }
        return resp;
    }
}
