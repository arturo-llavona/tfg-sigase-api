package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteListadoDTO;

import java.util.List;

public interface IncidentesService {
    public List<ClasificacionIncidenteDTO> findClasificacionIncidenteByCodigo(final String codigo);

    public List<IncidenteListadoDTO> findIncidentesEnCurso();
    public List<IncidenteListadoDTO> findIncidentesFinalizados();
}
