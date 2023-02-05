package com.allavona.tfg.api;

import com.allavona.tfg.api.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(description = "API de Incidentes", name = "Incidents")
    public interface IncidentesAPI {
    @Operation(summary = "Realiza una búsqueda de incidentes",
            description = "Este servicio permite realizar una búsqueda de los incidentes, especificando si están aún en curso o no.",
            tags = {"Incidents"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incidente.class)))),
            @ApiResponse(responseCode = "401", description = "Acceso no autorizado", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    ResponseEntity<List<Incidente>> buscarIncidentes(final Integer idUsuario, final boolean closed);

    @Operation(summary = "Obtiene el detalle de un incidente",
            description = "Este servicio permite consultar el detalle completo de un incidente.",
            tags = {"Incidents"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incidente.class)))),
            @ApiResponse(responseCode = "401", description = "Acceso no autorizado", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    ResponseEntity<Incidente> obtenerIncidente(final Integer idUsuario, final Integer idIncidente);

    @Operation(summary = "Crea un nuevo incidente", description = "Este servicio permite crear un nuevo incidente.", tags = { "Incidents"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Incidente creado con éxito", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "401", description  = "Acceso no autorizado", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    ResponseEntity<Incidente> crearIncidente(final Integer idUsuario, final Incidente incidente);

    @Operation(summary="Busca la clasificación incidente",
            description="Este servicio permite realizar una búsqueda de las clasificaciones de los incidentes a partir del comienzo de su código.",
            tags = {"Incidents"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content(schema = @Schema(implementation = ClasificacionIncidente.class))),
            @ApiResponse(responseCode = "404", description = "No se han encontrado resultados", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    ResponseEntity<ClasificacionIncidente> buscarClasificacionIncidente(final String codigo);

    @Operation(summary="Obtiene la lista de recursos a movilizar para una clasificación",
            description="Este servicio devuelve el listado de los tipos de recursos recomendados a movilizar para una clasificación de incidente determinada",
            tags = {"Incidents"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content(schema = @Schema(implementation = TipoRecurso.class))),
            @ApiResponse(responseCode = "404", description = "No se han encontrado resultados", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    ResponseEntity<List<TipoRecurso>> buscarPlantillaClasificacionIncidente(final Integer idClasificacionIncidente);
}
