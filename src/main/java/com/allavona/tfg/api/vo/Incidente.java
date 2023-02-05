package com.allavona.tfg.api.vo;

import com.allavona.tfg.business.dto.IncidentePersonaAfectadaDTO;
import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter @Setter @Builder @ToString
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Incidente implements Serializable {
    private Integer idIncidente;
    private Date fechaCreacion;
    private Date fechaFinalizacion;
    private String alertante;
    private String alias;
    private String localizacionDescripcion;
    private String localizacionLongitud;
    private String localizacionLatitud;
    private List<Observacion> observaciones;
    private IncidentePersonaAfectadaDTO personaAfectada;
    private List<TipoRecursoDTO> plantillaRecursos;
    private List<RecursoDTO> recursos;
    private ClasificacionIncidente clasificacionIncidente;
}
