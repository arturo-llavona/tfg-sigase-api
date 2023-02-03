package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;

import java.util.List;

public interface IncidentesService {
    public List<ClasificacionIncidenteDTO> findByCodigo(final String codigo);
}
