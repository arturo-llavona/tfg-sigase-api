package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.IncidentesAPI;
import com.allavona.tfg.api.converter.ClasificacionIncidenteDtoConverter;
import com.allavona.tfg.business.service.IncidentesService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/v1/incidents", produces="application/json")
@CrossOrigin(origins="*")
public class IncidentesController implements IncidentesAPI {
    @Autowired
    private IncidentesService incidentesService;

    private ClasificacionIncidenteDtoConverter converter = new ClasificacionIncidenteDtoConverter();

    @Override
    @RequestMapping(path = "/clasifications", produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity buscarClasificacionIncidente(
            @Parameter(description = "Inicio del código que se está buscando.", required = false,
                    schema = @Schema(type = "string"))
            @RequestParam(value = "codigo", required = false) final String codigo
    ) {
        return Optional
                .of(incidentesService.findByCodigo(codigo)
                        .stream()
                        .map(clasificacionIncidenteDTO -> converter.convert(clasificacionIncidenteDTO)).toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
