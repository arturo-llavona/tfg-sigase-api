package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.converter.UsuarioDtoConverter;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BaseController {
    @Autowired
    public UsuariosService usuariosService;
    public UsuarioDtoConverter usuarioDtoConverter = new UsuarioDtoConverter();
    public Usuario getUsuarioById(Integer idUsuario) {
        return Optional.ofNullable(usuariosService.getUsuarioById(idUsuario)).map(t -> usuarioDtoConverter.convert(t)).orElse(null);
    }
}
