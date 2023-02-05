package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.UsuariosAPI;
import com.allavona.tfg.api.vo.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/v1/users", produces="application/json")
@CrossOrigin(origins="*")
public class UsuarioController extends BaseController implements UsuariosAPI {
    @Override
    @RequestMapping( value = "/authenticate", produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    public ResponseEntity autenticar(@RequestBody Login login ) {
        return Optional.ofNullable(usuariosService.autenticar(usuarioDtoConverter.convert(login)))
                .map(usuario -> usuarioDtoConverter.convert(usuario))
                .map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
