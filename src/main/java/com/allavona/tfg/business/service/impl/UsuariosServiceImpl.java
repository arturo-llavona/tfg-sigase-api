package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.bbdd.repository.UsuarioRepository;
import com.allavona.tfg.business.converter.UsuarioEntityConverter;
import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.UsuariosService;
import com.allavona.tfg.business.utils.EncryptUtils;
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
        // Se realiza una consulta a la base de datos de un usuario que esté habilitado y su usuario y contraseña
        // corresponda con el usuario indicado, y con la encriptación de su contraseña.
        UsuarioEntity source = repository.autenticar(usuario.getUsername(), EncryptUtils.encrypt(usuario.getPassword()));
        // En caso de haber encontrado una ocurrencia, convertimos el objeto de tipo Entity a DTO utilizando su converter.
        UsuarioDTO resp = Optional.ofNullable(source).map(t-> converter.convert(t)).orElse(null);
        // En caso de haber encontrado una ocurrencia, "pisamos" su contraseña para que no viajen los datos,
        // ni encriptada ni sin encriptar, a modo de seguridad.
        if ( resp != null ) {
            resp.setPassword(null);
        }
        return resp;
    }
    @Override
    public UsuarioDTO getUsuarioByUsername(String username) {
        // Realizamos la consulta a base de datos de usuarios, a partir de su username.
        UsuarioEntity usuarioEntity = repository.findByUsername(username);
        return Optional.ofNullable(usuarioEntity).map(t -> {
            // En caso de encontrar una ocurrencia, realizamos la conversión de Entity a DTO utilizando su converter y
            // "pisamos" su contraseña.
            UsuarioDTO usuario = converter.convert(t);
            usuario.setPassword(null);
            return usuario;
        }).orElse(null);
    }
}
