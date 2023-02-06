package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IncidenteDtoConverter implements Converter<Incidente, IncidenteDTO> {
    private final ObservacionDtoConverter observacionDtoConverter;
    private final ClasificacionIncidenteDtoConverter clasificacionIncidenteDtoConverter;
    private final IncidentePersonaAfectadaDtoConverter incidentePersonaAfectadaDtoConverter;
    private final TipoRecursoDtoConverter tipoRecursoDtoConverter;
    private final RecursoDtoConverter recursoDtoConverter;
    public IncidenteDtoConverter(ObservacionDtoConverter observacionDtoConverter, ClasificacionIncidenteDtoConverter clasificacionIncidenteDtoConverter,
                                 IncidentePersonaAfectadaDtoConverter incidentePersonaAfectadaDtoConverter, TipoRecursoDtoConverter tipoRecursoDtoConverter,
                                 RecursoDtoConverter recursoDtoConverter) {
        this.observacionDtoConverter = observacionDtoConverter;
        this.clasificacionIncidenteDtoConverter = clasificacionIncidenteDtoConverter;
        this.incidentePersonaAfectadaDtoConverter = incidentePersonaAfectadaDtoConverter;
        this.tipoRecursoDtoConverter = tipoRecursoDtoConverter;
        this.recursoDtoConverter = recursoDtoConverter;
    }

    public IncidenteDTO convert(final Incidente source ) {
        final IncidenteDTO target = IncidenteDTO.builder().build();
        BeanUtils.copyProperties(source, target);

        if ( source.getPersonaAfectada() != null ) {
            target.setPersonaAfectada(incidentePersonaAfectadaDtoConverter.convert(source.getPersonaAfectada()));
        }
        if ( source.getClasificacionIncidente() != null ) {
            target.setClasificacionIncidente(clasificacionIncidenteDtoConverter.convert(source.getClasificacionIncidente()));
        }

        target.setPlantillaRecursos(Optional.ofNullable(source.getPlantillaRecursos()).map( t-> t.stream().map( o-> tipoRecursoDtoConverter.convert(o)).toList()).orElse(null));
        target.setRecursos(Optional.ofNullable(source.getRecursos()).map( t-> t.stream().map( o-> recursoDtoConverter.convert(o)).toList()).orElse(null));

        target.setObservaciones(Optional.ofNullable(source.getObservaciones()).map( t-> t.stream().map( o-> observacionDtoConverter.convert(o)).toList()).orElse(null));

        return target;
    }
}
