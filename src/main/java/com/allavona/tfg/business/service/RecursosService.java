package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;

import java.util.List;

public interface RecursosService {
    public List<RecursoDTO> findAll();

    public List<TipoRecursoDTO> listResourcesByIncidentClassification(final Integer idClasificacionIncidente);
}
