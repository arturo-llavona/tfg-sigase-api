package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.RecursosAPI;
import com.allavona.tfg.api.converter.RecursoConverter;
import com.allavona.tfg.api.utils.URLConstants;
import com.allavona.tfg.api.vo.ClasificacionIncidente;
import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.service.RecursosService;
import com.allavona.tfg.business.service.UsuariosService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= URLConstants.RESOURCES_V1_URL, produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class RecursoController extends BaseController implements RecursosAPI {
    private final RecursosService recursosService;

    public RecursoController(RecursosService recursosService, GenericConversionService genericConversionService, UsuariosService usuariosService) {
        super(usuariosService, genericConversionService);
        this.recursosService = recursosService;
    }

    @Override
    @RequestMapping( produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity listar(
            @RequestParam(value="type", required = false) final Integer idTipoRecurso,
            @RequestParam(value = "onlyAvailable", required = false, defaultValue = "true") final Boolean onlyAvailable) {
        List<RecursoDTO> source = onlyAvailable ? recursosService.findRecursosDisponibles(idTipoRecurso) : recursosService.findAll(idTipoRecurso);
        List<Recurso> target = (List<Recurso>) this.genericConversionService.convert(source, TypeDescriptor.forObject(source), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Recurso.class)));
        return Optional
                .of(target).map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
