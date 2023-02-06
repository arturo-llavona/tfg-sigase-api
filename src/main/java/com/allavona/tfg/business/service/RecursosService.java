package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;

import java.util.List;

public interface RecursosService {
    public List<RecursoDTO> findAll(final Integer idTipoRecurso);
    public List<RecursoDTO> findRecursosDisponibles(final Integer idTipoRecurso);
    public List<TipoRecursoDTO> listResourcesByIncidentClassification(final Integer idClasificacionIncidente);
}
