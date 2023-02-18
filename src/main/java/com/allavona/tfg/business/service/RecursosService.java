package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;

import java.util.List;

public interface RecursosService {
    // Método que devuelve todos los recursos a partir de su tipo.
    public List<RecursoDTO> findAll(final Integer idTipoRecurso);
    // Método que devuelve todos los recursos disponibles a partir de su tipo.
    public List<RecursoDTO> findRecursosDisponibles(final Integer idTipoRecurso);
    // Método que devuelve todos los tipos de recurso que deberían asignarse a una incidencia con una clasificación específica.
    public List<TipoRecursoDTO> listResourcesByIncidentClassification(final Integer idClasificacionIncidente);
}
