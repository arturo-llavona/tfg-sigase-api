package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.IncidentesAPI;
import com.allavona.tfg.api.converter.ClasificacionIncidenteDtoConverter;
import com.allavona.tfg.api.converter.IncidenteDtoConverter;
import com.allavona.tfg.api.converter.TipoRecursoDtoConverter;
import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.service.IncidentesService;
import com.allavona.tfg.business.service.RecursosService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/v1/incidents", produces="application/json")
@CrossOrigin(origins="*")
public class IncidentesController implements IncidentesAPI {
    @Autowired
    private IncidentesService incidentesService;

    @Autowired
    private RecursosService recursosService;

    private IncidenteDtoConverter incidenteDtoConverter = new IncidenteDtoConverter();
    private ClasificacionIncidenteDtoConverter clasificacionIncidenteDtoConverter = new ClasificacionIncidenteDtoConverter();

    private TipoRecursoDtoConverter tipoRecursoDtoConverter = new TipoRecursoDtoConverter();

    @Override
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<List<Incidente>> buscarIncidentes(
            @Parameter(description = "Parámetro que indica si el incidente ya ha sido finalizado.", required = false, schema = @Schema(type = "boolean"))
            @RequestParam(value = "closed", required = false, defaultValue = "false") final boolean closed) {
        List<IncidenteDTO> source = null;
        if ( closed ) {
            source = incidentesService.findIncidentesFinalizados();
        } else {
            source = incidentesService.findIncidentesEnCurso();
        }
        return Optional
                .of(source.stream().map( incidenteDTO -> incidenteDtoConverter.convert(incidenteDTO)).toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    @RequestMapping(path = "/classifications", produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity buscarClasificacionIncidente(
            @Parameter(description = "Inicio del código que se está buscando.", required = false,
                    schema = @Schema(type = "string"))
            @RequestParam(value = "codigo", required = false) final String codigo
    ) {
        return Optional
                .of(incidentesService.findByCodigo(codigo)
                        .stream()
                        .map(clasificacionIncidenteDTO -> clasificacionIncidenteDtoConverter.convert(clasificacionIncidenteDTO)).toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    @RequestMapping(path = "/classifications/{id}/recommended-resources-type-list", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<TipoRecurso>> buscarPlantillaClasificacionIncidente(
            @Parameter(description = "Identificador de la clasificación del incidente.", required = true)
            @PathVariable(name="id", required = true) final Integer id) {
        return Optional
                .of(recursosService.listResourcesByIncidentClassification(id)
                        .stream()
                        .map(tipoRecursoDTO -> tipoRecursoDtoConverter.convert(tipoRecursoDTO)).toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
