package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.UsuariosService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BaseController {
    // Este controller base del que extienden el resto, provee de algunos atributos y métodos que son utilizados
    // desde todos, para no duplicar código.

    // Servicio que permite acceder a los métodos para trabajar con usuarios.
    public final UsuariosService usuariosService;

    // Servicio genérico que permite realizar conversiones de objetos.
    public final GenericConversionService genericConversionService;

    public BaseController(UsuariosService usuariosService, GenericConversionService genericConversionService) {
        this.usuariosService = usuariosService;
        this.genericConversionService = genericConversionService;
    }

    // Este método obtiene los datos de un usuario de base de datos a partir de su username.
    public Usuario getUsuarioByUsername(String username) {
        // Buscamos el usuario en base de datos.
        UsuarioDTO source = usuariosService.getUsuarioByUsername(username);
        // Realizamos una conversión a VO
        Usuario target = genericConversionService.convert(source, Usuario.class);
        return Optional.ofNullable(target).orElse(null);
    }
}
