package com.allavona.tfg.api;

import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;


@Tag(description = "API de Usuarios", name = "Usuarios")
    public interface UsuariosAPI { @Operation(summary="autenticar", description="Comprueba si el usuario y contraseña introducido es correcto", tags = {"Usuarios"})
    ResponseEntity<Usuario> autenticar(final Login login);
}
