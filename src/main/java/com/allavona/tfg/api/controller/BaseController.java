package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.UsuariosService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BaseController {
    public final UsuariosService usuariosService;
    public final GenericConversionService genericConversionService;

    public BaseController(UsuariosService usuariosService, GenericConversionService genericConversionService) {
        this.usuariosService = usuariosService;
        this.genericConversionService = genericConversionService;
    }

    public Usuario getUsuarioByUsername(String username) {
        UsuarioDTO source = usuariosService.getUsuarioByUsername(username);
        Usuario target = genericConversionService.convert(source, Usuario.class);
        return Optional.ofNullable(target).orElse(null);
    }
}
