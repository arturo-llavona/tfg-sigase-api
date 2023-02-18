package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class IncidenteDTO {
    private Integer idIncidente;
    private Date fechaCreacion;
    private Date fechaFinalizacion;
    private String alertante;
    private String alias;
    private String localizacionDescripcion;
    private String localizacionLongitud;
    private String localizacionLatitud;
    private List<ObservacionDTO> observaciones;
    private IncidentePersonaAfectadaDTO personaAfectada;
    private List<TipoRecursoDTO> plantillaRecursos;
    private List<RecursoDTO> recursos;
    private ClasificacionIncidenteDTO clasificacionIncidente;
}
