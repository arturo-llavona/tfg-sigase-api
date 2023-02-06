package com.allavona.tfg.api.controller;

import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.service.RecursosService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecursoControllerTest {
    @Autowired
    private RecursosService recursosService;

    @Test
    @DisplayName("Listar recursos habilitados")
    void listar() {
        List<RecursoDTO> recursos =  recursosService.findAll(null);
        assertNotNull(recursos);
        assertTrue(recursos.size() > 0);
    }
}