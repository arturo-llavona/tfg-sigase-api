package com.allavona.tfg.api.controller;

import com.allavona.tfg.api.IncidentesAPI;
import com.allavona.tfg.api.utils.SecurityUtils;
import com.allavona.tfg.api.utils.URLConstants;
import com.allavona.tfg.api.vo.ClasificacionIncidente;
import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import com.allavona.tfg.business.dto.UsuarioDTO;
import com.allavona.tfg.business.service.IncidentesService;
import com.allavona.tfg.business.service.RecursosService;
import com.allavona.tfg.business.service.UsuariosService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.allavona.tfg.api.utils.Constants.USERNAME_HEADER;
import static com.allavona.tfg.api.utils.Constants.USERNAME_HEADER_DESCRIPTION;

@RestController
@RequestMapping(path= URLConstants.INCIDENTS_V1_URL, produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class IncidentesController extends BaseController implements IncidentesAPI {
    private final IncidentesService incidentesService;
    private final RecursosService recursosService;
    private static Logger logger = LogManager.getLogger();
    public IncidentesController(IncidentesService incidentesService, RecursosService recursosService, GenericConversionService genericConversionService, UsuariosService usuariosService) {
        super(usuariosService, genericConversionService);
        this.incidentesService = incidentesService;
        this.recursosService = recursosService;;
    }
    @Override
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<List<Incidente>> buscarIncidentes(
            @Parameter(description = USERNAME_HEADER_DESCRIPTION, required=true)
            @RequestHeader(value = USERNAME_HEADER, required = true) final String username,
            @Parameter(description = "Parámetro que indica si el incidente ya ha sido finalizado.", required = false, schema = @Schema(type = "boolean"))
            @RequestParam(value = "closed", required = false, defaultValue = "false") final boolean closed) {

        ResponseEntity<List<Incidente>> respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        try {
            // Realiza una consulta a la capa de servicios de la información del usuario que está realizando la consulta.
            Usuario usuario = getUsuarioByUsername(username);
            // Se realiza una comprobación de que el usuario tiene acceso a crear incidentes.
            SecurityUtils.checkIsUsuarioConPerfilConsulta(usuario);

            // Se realiza la consulta a la capa de servicios de los incidentes, en curso o finalizados dependiendo de
            // lo que ha pedido el usuario.
            List<IncidenteDTO> source;
            if (closed) {
                source = incidentesService.findIncidentesFinalizados();
            } else {
                source = incidentesService.findIncidentesEnCurso();
            }
            // Realiza la conversión de los resultados
            List<Incidente> target = (List<Incidente>) this.genericConversionService.convert(source, TypeDescriptor.forObject(source), TypeDescriptor.collection(List. class, TypeDescriptor.valueOf(Incidente.class)));
            // En caso de haber encontrado respuesta, se responde con un OK (200) después de filtrar las observaciones
            // con datos médicos. En caso contario, con un NOT_FOUND (404).
            respuesta = Optional.ofNullable(SecurityUtils.filtrarObservacionesConDatosMedicos(target, usuario)).map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (ResponseStatusException e) {
            logger.warn("Un usuario ha intentado acceder a un recurso al que no tenía permiso.", e.getMessage());
        } catch (Exception e) {
            logger.error("Ha ocurrido un error", e.getMessage());
        } finally {
            return respuesta;
        }
    }
    @Override
    @RequestMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<Incidente> obtenerIncidente(
            @Parameter(description = USERNAME_HEADER_DESCRIPTION, required=true )
            @RequestHeader(value = USERNAME_HEADER, required = true) final String username,
            @Parameter(description = "Identificador del incidente.", required = true)
            @PathVariable(name="id", required = true) final Integer idIncidente) {
        ResponseEntity<Incidente> respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        try {
            // Realiza una consulta a la capa de servicios de la información del usuario que está realizando la consulta.
            Usuario usuario = getUsuarioByUsername(username);
            // Se realiza una comprobación de que el usuario tiene acceso a crear incidentes.
            SecurityUtils.checkIsUsuarioConPerfilConsulta(usuario);
            // Se realiza una consulta a la capa de servicios del incidente especificado, a través de su identificador.
            Incidente incidente = Optional.ofNullable(incidentesService.findIncidenteById(idIncidente)).map(i -> genericConversionService.convert(i, Incidente.class)).get();
            // Se realiza el filtrado de sus comentarios a partir del usuario que está logado y su tipo.
            SecurityUtils.filtrarObservacionesConDatosMedicos(incidente, usuario);
            // En caso de haber encontrado respuesta, se responde con un OK (200). En caso contario, con un NOT_FOUND (404).
            respuesta = Optional.ofNullable(incidente).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (ResponseStatusException e) {
            logger.warn("Un usuario ha intentado acceder a un recurso al que no tenía permiso.");
        } catch (NoSuchElementException e) {
          logger.warn("Se ha intentado acceder a un recurso que no existe.");
          respuesta = ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error("Ha ocurrido un error", e.getMessage());
        } finally {
            return respuesta;
        }
    }
    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Incidente> crearIncidente(
            @Parameter(description = USERNAME_HEADER_DESCRIPTION, required=true )
            @RequestHeader(value = USERNAME_HEADER, required = true) final String username,
            @RequestBody final Incidente incidente) {
        ResponseEntity<Incidente> respuesta = ResponseEntity.badRequest().build();
        try {
            // Realiza una consulta a la capa de servicios de la información del usuario que está realizando la consulta.
            Usuario usuario = getUsuarioByUsername(username);
            // Se realiza una comprobación de que el usuario tiene acceso a crear incidentes.
            SecurityUtils.checkIsUsuarioConPerfilConsulta(usuario);

            logger.info("Se va a proceder a insertar en base de datos el un incidente.");
            logger.debug(incidente.toString());
            // Se realiza una llamada a la capa de servicios para insertar el incidente.
            IncidenteDTO incidenteCreado = incidentesService.crearIncidente(genericConversionService.convert(usuario, UsuarioDTO.class), genericConversionService.convert(incidente, IncidenteDTO.class));
            logger.info("Se ha creado el incidente correctamente.");
            logger.debug(incidenteCreado.toString());
            // Como recomendación del estándar REST, no se devuelve el objeto creado completo, sino que se devuelve su
            // location por si desea consultarse su detalle. Así se ahorra en tráfico de datos.
            URI location = URI.create(String.format(URLConstants.INCIDENTS_V1_URL + "/%d", incidenteCreado.getIdIncidente()));
            // En caso de haberse realizado la inserción correctamente, se devuelve un status CREATED (201) y se devuelve
            // el location.
            respuesta = ResponseEntity.created(location).build();
        } catch ( Exception e) {
            logger.error("Ha ocurrido un error", e.getMessage());
            e.printStackTrace();
        }
        return respuesta;
    }
    @Override
    @RequestMapping(path = URLConstants.CLASSIFICATIONS_URL, produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity<List<ClasificacionIncidente>> buscarClasificacionIncidente(
            @Parameter(description = "Inicio del código que se está buscando.", required = false,
                    schema = @Schema(type = "string"))
            @RequestParam(value = "codigo", required = false) final String codigo
    ) {
        ResponseEntity respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        try {
            // Realizamos la consulta a la capa de servicios.
            List<ClasificacionIncidenteDTO> source = incidentesService.findClasificacionIncidenteByCodigo(codigo);
            // Se realiza la conversión de tipo DTO a tipo VO
            List<ClasificacionIncidente> target = (List<ClasificacionIncidente>) this.genericConversionService.convert(source, TypeDescriptor.forObject(source), TypeDescriptor.collection(List. class, TypeDescriptor.valueOf(ClasificacionIncidente.class)));
            // En caso de haber obtenido resultados, se responde la información con un OK (200), en caso contrario se devuelve
            // un HttpStatus NOT_FOUND (404).
            respuesta = Optional
                    .ofNullable(target)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            logger.error("Ha ocurrido un error", e.getMessage());
        } finally {
            return respuesta;
        }
    }
    @Override
    @RequestMapping(path = URLConstants.CLASSIFICATIONS_TEMPLATE_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<TipoRecurso>> buscarPlantillaClasificacionIncidente(
            @Parameter(description = "Identificador de la clasificación del incidente.", required = true)
            @PathVariable(name="id", required = true) final Integer id) {
        ResponseEntity<List<TipoRecurso>> respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        try {
            // Realizamos la consulta a la capa de servicios.
            List<TipoRecursoDTO> source = recursosService.listResourcesByIncidentClassification(id);
            // Se realiza la conversión de tipo DTO a tipo VO
            List<TipoRecurso> target = (List<TipoRecurso>) this.genericConversionService.convert(source, TypeDescriptor.forObject(source), TypeDescriptor.collection(List. class, TypeDescriptor.valueOf(TipoRecurso.class)));
            // En caso de haber obtenido resultados, se responde la información con un OK (200), en caso contrario se devuelve
            // un HttpStatus NOT_FOUND (404).
            respuesta = Optional.ofNullable(target)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            logger.error("Ha ocurrido un error", e.getMessage());
        } finally {
            return respuesta;
        }
    }
}
