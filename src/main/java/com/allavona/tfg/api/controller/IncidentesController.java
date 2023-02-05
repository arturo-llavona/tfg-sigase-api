package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.IncidentesAPI;
import com.allavona.tfg.api.converter.ClasificacionIncidenteDtoConverter;
import com.allavona.tfg.api.converter.IncidenteDtoConverter;
import com.allavona.tfg.api.converter.TipoRecursoDtoConverter;
import com.allavona.tfg.api.utils.SecurityUtils;
import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.api.vo.Usuario;
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

import static com.allavona.tfg.api.utils.Constants.ID_USUARIO_HEADER;
import static com.allavona.tfg.api.utils.Constants.ID_USUARIO_HEADER_DESCRIPTION;

@RestController
@RequestMapping(path="/v1/incidents", produces="application/json")
@CrossOrigin(origins="*")
public class IncidentesController extends BaseController implements IncidentesAPI {
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
            @Parameter(description = ID_USUARIO_HEADER_DESCRIPTION, required=true)
            @RequestHeader(value = ID_USUARIO_HEADER, required = true) final Integer idUsuario,
            @Parameter(description = "Parámetro que indica si el incidente ya ha sido finalizado.", required = false, schema = @Schema(type = "boolean"))
            @RequestParam(value = "closed", required = false, defaultValue = "false") final boolean closed) {
        Usuario usuario = getUsuarioById(idUsuario);
        SecurityUtils.checkIsUsuarioConPerfilConsulta(usuario);

        List<IncidenteDTO> source;
        if (closed) {
            source = incidentesService.findIncidentesFinalizados();
        } else {
            source = incidentesService.findIncidentesEnCurso();
        }
        List<Incidente> incidentes = SecurityUtils.filtrarObservacionesConDatosMedicos(
                source.stream().map(i -> incidenteDtoConverter.convert(i)).toList(), usuario);
        return Optional
                .of(incidentes).map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @Override
    @RequestMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<Incidente> obtenerIncidente(
            @Parameter(description = ID_USUARIO_HEADER_DESCRIPTION, required=true )
            @RequestHeader(value = ID_USUARIO_HEADER, required = true) final Integer idUsuario,
            @Parameter(description = "Identificador del incidente.", required = true)
            @PathVariable(name="id", required = true) final Integer idIncidente) {

        Usuario usuario = getUsuarioById(idUsuario);
        SecurityUtils.checkIsUsuarioConPerfilConsulta(usuario);
        Incidente incidente = Optional.of(incidentesService.findIncidenteById(idIncidente)).map(i-> incidenteDtoConverter.convert(i)).get();
        SecurityUtils.filtrarObservacionesConDatosMedicos(incidente, usuario);
        return Optional.of(incidente).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
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
