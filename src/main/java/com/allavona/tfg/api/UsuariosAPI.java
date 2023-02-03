package com.allavona.tfg.api;

import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


@Tag(description = "API de Usuarios", name = "Users")
    public interface UsuariosAPI {
    @Operation(summary="Verificación de credenciales",
            description="Comprueba si la tupla usuario - contraseña introducidos son correctos",
            tags = {"Users"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Login realizado correctamente", content = @Content(schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "401", description = "Credenciales incorrectas", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    ResponseEntity<Usuario> autenticar(final Login login);

}
