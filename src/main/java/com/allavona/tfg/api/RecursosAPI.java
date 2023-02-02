package com.allavona.tfg.api;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(description = "API de Recursos", name = "Recursos")
    public interface RecursosAPI { @Operation(summary="listar todos los recursos", description="Servicio que lista todos los recursos", tags = {"Recursos"})
    ResponseEntity<List<Recurso>> listar();
}
