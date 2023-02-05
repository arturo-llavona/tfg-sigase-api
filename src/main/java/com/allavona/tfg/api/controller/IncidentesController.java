package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.IncidentesAPI;
import com.allavona.tfg.api.converter.ClasificacionIncidenteDtoConverter;
import com.allavona.tfg.api.converter.IncidenteListadoDtoConverter;
import com.allavona.tfg.api.converter.TipoRecursoDtoConverter;
import com.allavona.tfg.api.vo.IncidenteListado;
import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.business.dto.IncidenteListadoDTO;
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

import static com.allavona.tfg.api.utils.Constants.*;

@RestController
@RequestMapping(path="/v1/incidents", produces="application/json")
@CrossOrigin(origins="*")
public class IncidentesController extends BaseController implements IncidentesAPI {
    @Autowired
    private IncidentesService incidentesService;

    @Autowired
    private RecursosService recursosService;

    private IncidenteListadoDtoConverter incidenteListadoDtoConverter = new IncidenteListadoDtoConverter();
    private ClasificacionIncidenteDtoConverter clasificacionIncidenteDtoConverter = new ClasificacionIncidenteDtoConverter();
    private TipoRecursoDtoConverter tipoRecursoDtoConverter = new TipoRecursoDtoConverter();

    @Override
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<List<IncidenteListado>> buscarIncidentes(
            @Parameter(description = "Parámetro que indica si el incidente ya ha sido finalizado.", required = false, schema = @Schema(type = "boolean"))
            @RequestParam(value = "closed", required = false, defaultValue = "false") final boolean closed,
            @Parameter(description = TIPO_USUARIO_HEADER_DESCRIPTION, required=true, schema = @Schema(type = "string", allowableValues = { "AGENTE", "MEDICO", "ADMINISTRADOR"}) )
            @RequestHeader(value = TIPO_USUARIO_HEADER, required = true) final String tipoUsuario) {
        List<IncidenteListadoDTO> source = null;

        if (isUsuarioConPerfilConsulta(tipoUsuario)) {
            if (closed) {
                source = incidentesService.findIncidentesFinalizados();
            } else {
                source = incidentesService.findIncidentesEnCurso();
            }
            return Optional
                    .of(source.stream().map(incidenteDTO -> incidenteListadoDtoConverter.convert(incidenteDTO)).toList())
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Override
    @RequestMapping(path = "/classifications", produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity buscarClasificacionIncidente(
            @Parameter(description = "Inicio del código que se está buscando.", required = false,
                    schema = @Schema(type = "string"))
            @RequestParam(value = "codigo", required = false) final String codigo
    ) {
        return Optional
                .of(incidentesService.findClasificacionIncidenteByCodigo(codigo)
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
