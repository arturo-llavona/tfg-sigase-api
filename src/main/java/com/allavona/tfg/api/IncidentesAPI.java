package com.allavona.tfg.api;

import com.allavona.tfg.api.vo.ClasificacionIncidente;
import com.allavona.tfg.api.vo.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


@Tag(description = "API de Incidentes", name = "Incidentes")
    public interface IncidentesAPI {

    @Operation(summary="Buscar clasificación incidente", description="Realiza una búsqueda de clasificación de incidentes a partir de su código", tags = {"Incidentes"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "404", description = "No se ha encontrado ninguna clasificación de incidente coincidente con el inicio de código buscado", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "200", description = "Listado de códigos recuperados", content = @Content(schema = @Schema(implementation = ClasificacionIncidente.class)))
    })
    ResponseEntity<ClasificacionIncidente> buscarClasificacionIncidente(final String codigo);
}
