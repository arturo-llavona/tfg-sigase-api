package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.RecursosAPI;
import com.allavona.tfg.api.converter.RecursoDtoConverter;
import com.allavona.tfg.api.utils.URLConstants;
import com.allavona.tfg.business.service.RecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path= URLConstants.RESOURCES_V1_URL, produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class RecursoController implements RecursosAPI {
    private final RecursosService recursosService;
    private RecursoDtoConverter recursoDtoConverter = new RecursoDtoConverter();

    public RecursoController(RecursosService recursosService) {
        this.recursosService = recursosService;
    }

    @Override
    @RequestMapping( produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity listar() {
        return Optional
                .of(recursosService.findAll()
                        .stream()
                        .map(recursoDTO -> recursoDtoConverter.convert(recursoDTO)).toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
