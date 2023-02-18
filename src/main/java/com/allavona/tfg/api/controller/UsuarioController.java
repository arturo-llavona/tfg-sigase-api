package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.UsuariosAPI;
import com.allavona.tfg.api.utils.URLConstants;
import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.UsuariosService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path= URLConstants.USERS_V1_URL, produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class UsuarioController extends BaseController implements UsuariosAPI {
    public UsuarioController(UsuariosService usuariosService, GenericConversionService genericConversionService) {
        super(usuariosService, genericConversionService);
    }
    @Override
    @RequestMapping( value = URLConstants.USERS_AUTHENTICATION_URL, produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    public ResponseEntity autenticar(@RequestBody Login login ) {
        // Se devuelve información del usuario que está realizando login en caso de encontrar un usuario en el sistema
        // cuyo username y password sea el indicado en el objeto de entrada.
        // Se responde con un OK (200) en caso de haber encontrado coincidencia, o un UNAUTHORIZED (401) en caso contrario.
        // En ese caso, lo más probable es que se hayan introducido las credenciales incorrectas.
        return Optional.ofNullable(usuariosService.autenticar(genericConversionService.convert(login, UsuarioDTO.class)))
                .map(usuario -> genericConversionService.convert(usuario, Usuario.class))
                .map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
