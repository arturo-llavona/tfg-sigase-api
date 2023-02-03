package com.allavona.tfg.api;

import com.allavona.tfg.api.vo.ClasificacionIncidente;
import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.api.vo.Usuario;
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
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incidente.class))))
    })
    ResponseEntity<List<Incidente>> buscarIncidentes(final boolean closed);


    @Operation(summary="Busca la clasificación incidente",
            description="Este servicio permite realizar una búsqueda de las clasificaciones de los incidentes a partir del comienzo de su código.",
            tags = {"Incidents"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "404", description = "No se han encontrado resultados",
                    content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content(schema = @Schema(implementation = ClasificacionIncidente.class)))
    })
    ResponseEntity<ClasificacionIncidente> buscarClasificacionIncidente(final String codigo);

    @Operation(summary="Obtiene la lista de recursos a movilizar para una clasificación",
            description="Este servicio devuelve el listado de los tipos de recursos recomendados a movilizar para una clasificación de incidente determinada",
            tags = {"Incidents"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "404", description = "No se han encontrado resultados",
                    content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content(schema = @Schema(implementation = TipoRecurso.class)))
    })
    ResponseEntity<List<TipoRecurso>> buscarPlantillaClasificacionIncidente(final Integer idClasificacionIncidente);
}
