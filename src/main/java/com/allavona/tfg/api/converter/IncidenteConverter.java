package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IncidenteConverter implements Converter<IncidenteDTO, Incidente> {
    private final ObservacionConverter observacionConverter;
    private final ClasificacionIncidenteConverter clasificacionIncidenteConverter;
    private final IncidentePersonaAfectadaConverter incidentePersonaAfectadaConverter;
    private final TipoRecursoConverter tipoRecursoConverter;
    private final RecursoConverter recursoConverter;

    public IncidenteConverter(ObservacionConverter observacionConverter, ClasificacionIncidenteConverter clasificacionIncidenteConverter,
                              IncidentePersonaAfectadaConverter incidentePersonaAfectadaConverter, TipoRecursoConverter tipoRecursoConverter,
                              RecursoConverter recursoConverter) {
        this.observacionConverter = observacionConverter;
        this.clasificacionIncidenteConverter = clasificacionIncidenteConverter;
        this.incidentePersonaAfectadaConverter = incidentePersonaAfectadaConverter;
        this.tipoRecursoConverter = tipoRecursoConverter;
        this.recursoConverter = recursoConverter;
    }

    public Incidente convert(final IncidenteDTO source ) {
        final Incidente target = Incidente.builder().build();
        BeanUtils.copyProperties(source, target);

        if ( source.getPersonaAfectada() != null ) {
            target.setPersonaAfectada(incidentePersonaAfectadaConverter.convert(source.getPersonaAfectada()));
        }
        if ( source.getClasificacionIncidente() != null ) {
            target.setClasificacionIncidente(clasificacionIncidenteConverter.convert(source.getClasificacionIncidente()));
        }

        target.setPlantillaRecursos(Optional.ofNullable(source.getPlantillaRecursos()).map( t-> t.stream().map( o-> tipoRecursoConverter.convert(o)).toList()).orElse(null));
        target.setRecursos(Optional.ofNullable(source.getRecursos()).map( t-> t.stream().map( o-> recursoConverter.convert(o)).toList()).orElse(null));
        target.setObservaciones(Optional.ofNullable(source.getObservaciones()).map( t-> t.stream().map( o-> observacionConverter.convert(o)).toList()).orElse(null));

        return target;
    }
}
