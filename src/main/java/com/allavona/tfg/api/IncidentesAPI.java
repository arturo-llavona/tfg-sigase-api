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


@Tag(description = "API de Incidentes", name = "Incidentes")
    public interface IncidentesAPI {
    @Operation(summary = "Busca los incidentes en curso", description = "Servicio que realiza una búsqueda de los incidentes", tags = {"Incidentes"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incidente.class))))
    })
    ResponseEntity<List<Incidente>> buscarIncidentes(final boolean closed);


    @Operation(summary="Buscar clasificación incidente", description="Realiza una búsqueda de clasificación de incidentes a partir de su código", tags = {"Incidentes"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "404", description = "No se han encontrado resultados",
                    content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "200", description = "Listado de códigos recuperados", content = @Content(schema = @Schema(implementation = ClasificacionIncidente.class)))
    })
    ResponseEntity<ClasificacionIncidente> buscarClasificacionIncidente(final String codigo);

    @Operation(summary="Obtener lista recursos a movilizar", description="Obtiene la lista de recursos a movilizar recomendada para una clasificación de incidente", tags = {"Incidentes"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "404", description = "No se han encontrado resultados",
                    content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "200", description = "Listado de tipos de recursos a movilizar", content = @Content(schema = @Schema(implementation = TipoRecurso.class)))
    })
    ResponseEntity<List<TipoRecurso>> buscarPlantillaClasificacionIncidente(final Integer idClasificacionIncidente);
}
