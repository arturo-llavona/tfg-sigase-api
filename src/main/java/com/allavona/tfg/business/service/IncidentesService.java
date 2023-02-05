package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteDTO;

import java.util.List;

public interface IncidentesService {
    public List<ClasificacionIncidenteDTO> findClasificacionIncidenteByCodigo(final String codigo);
    public List<IncidenteDTO> findIncidentesEnCurso();
    public List<IncidenteDTO> findIncidentesFinalizados();
    public IncidenteDTO findIncidenteById(final Integer idIncidente);
}
