package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.UsuariosAPI;
import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/v1/usuarios", produces="application/json")
@CrossOrigin(origins="*")
public class UsuarioController implements UsuariosAPI {
    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private GenericConversionService genericConversionService;

    @Override
    @RequestMapping( value = "/autenticar", produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    public ResponseEntity<Usuario> autenticar(@RequestBody Login login ) {
        Usuario usuario = usuariosService.autenticar(login);
        if ( usuario == null ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }
}
