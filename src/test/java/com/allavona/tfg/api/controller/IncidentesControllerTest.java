package com.allavona.tfg.api.controller;

import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteListadoDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import com.allavona.tfg.business.service.IncidentesService;
import com.allavona.tfg.business.service.RecursosService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IncidentesControllerTest {
    @Autowired
    private IncidentesService incidentesService;

    @Autowired
    private RecursosService recursosService;

    @Test
    @DisplayName("Buscar incidentes")
    void buscarIncidentes() {
        List<IncidenteListadoDTO> incidentesEnCurso = incidentesService.findIncidentesEnCurso();
        assertNotNull(incidentesEnCurso);
        assertTrue(incidentesEnCurso.size() > 0);
    }

    @Test
    @DisplayName("Buscar clasificación de incidente")
    void buscarClasificacionIncidente() {
        List<ClasificacionIncidenteDTO> clasificacionIncidenteDTOS = incidentesService.findClasificacionIncidenteByCodigo("7");
        assertNotNull(clasificacionIncidenteDTOS);
        assertTrue(clasificacionIncidenteDTOS.size() > 0);
    }

    @Test
    @DisplayName("Buscar plantilla clasificacion incidente")
    void buscarPlantillaClasificacionIncidente() {
        List<TipoRecursoDTO> tipoRecursosDTOS = recursosService.listResourcesByIncidentClassification(13);
        assertNotNull(tipoRecursosDTOS);
        assertTrue(tipoRecursosDTOS.size() > 0);
    }
}