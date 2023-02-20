package com.allavona.tfg.business.service;

import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.dto.UsuarioDTO;

import java.util.List;

public interface IncidentesService {
    // Método que devuelve todas las posibles clasificaciones de incidentes que comiencen por un String determinado.
    List<ClasificacionIncidenteDTO> findClasificacionIncidenteByCodigo(final String codigo);
    // Método que devuelve todos los incidentes actualmente en curso.
    List<IncidenteDTO> findIncidentesEnCurso();
    // Método que devuelve todos los incidentes finalizados.
    List<IncidenteDTO> findIncidentesFinalizados();
    // Método que devuelve el detalle de un incidente a partir de su identificador.
    IncidenteDTO findIncidenteById(final Integer idIncidente);
    // Método que inserta un incidente en la base de datos.
    IncidenteDTO crearIncidente(final UsuarioDTO usuario, final IncidenteDTO incidente);
}
