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


@Tag(description = "API de Usuarios", name = "Usuarios")
    public interface UsuariosAPI {

    @Operation(summary="autenticar", description="Comprueba si el usuario y contraseña introducido es correcto", tags = {"Usuarios"})
    @ApiResponses( value = {
            @ApiResponse(responseCode = "401", description = "Credenciales incorrectas", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "200", description = "Login realizado correctamente", content = @Content(schema = @Schema(implementation = Usuario.class)))
    })
    ResponseEntity<Usuario> autenticar(final Login login);
}
