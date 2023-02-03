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


@Tag(description = "API de Recursos", name = "Recursos")
    public interface RecursosAPI {

    @Operation(summary="listar todos los recursos", description="Servicio que lista todos los recursos", tags = {"Recursos"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de todos los recursos", content = @Content( array = @ArraySchema( schema = @Schema(implementation = Recurso.class)))),
            @ApiResponse(responseCode =  "401", description = "No se ha encontrado ningún recurso", content = @Content( schema = @Schema(implementation = Void.class)))
    })
    ResponseEntity<List<Recurso>> listar();
}
