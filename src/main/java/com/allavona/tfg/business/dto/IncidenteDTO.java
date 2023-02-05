package com.allavona.tfg.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter @Setter @Builder @ToString
public class IncidenteDTO {
    private int idIncidente;
    private Date fechaCreacion;
    private Date fechaFinalizacion;
    private String alertante;
    private String alias;
    private String localizacionDescripcion;
    private BigDecimal localizacionLongitud;
    private BigDecimal localizacionLatitud;
    private List<ObservacionDTO> observaciones;
    private IncidentePersonaAfectadaDTO personaAfectada;
    private List<TipoRecursoDTO> plantillaRecursos;
    private List<RecursoDTO> recursos;
}
