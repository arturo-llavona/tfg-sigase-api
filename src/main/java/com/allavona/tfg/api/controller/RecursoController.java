package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.RecursosAPI;
import com.allavona.tfg.api.converter.RecursoDtoConverter;
import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.service.RecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/v1/recursos", produces="application/json")
@CrossOrigin(origins="*")
public class RecursoController implements RecursosAPI {
    @Autowired
    private RecursosService recursosService;

    private RecursoDtoConverter recursoDtoConverter = new RecursoDtoConverter();

    @Override
    @RequestMapping( value = "/listar", produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity listar() {
        return Optional
                .of(recursosService.findAll()
                        .stream()
                        .map(recursoDTO -> recursoDtoConverter.convert(recursoDTO)).toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
