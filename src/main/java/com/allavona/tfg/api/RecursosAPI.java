package com.allavona.tfg.api;

import com.allavona.tfg.api.vo.Recurso;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(description = "API de Recursos", name = "Resources")
    public interface RecursosAPI {

    @Operation(summary="Lista todos los recursos",
            description="Este servicio lista todos los recursos del sistema",
            tags = {"Resources"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta finalizada con éxito", content = @Content( array = @ArraySchema( schema = @Schema(implementation = Recurso.class)))),
            @ApiResponse(responseCode =  "401", description = "No se han encontrado resultados", content = @Content( schema = @Schema(implementation = Void.class)))
    })
    ResponseEntity<List<Recurso>> listar(final Integer tipoRecurso, final Boolean onlyAvailable);
}
