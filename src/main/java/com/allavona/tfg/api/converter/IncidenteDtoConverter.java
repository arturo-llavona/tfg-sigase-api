package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IncidenteDtoConverter implements Converter<Incidente, IncidenteDTO> {
    @Autowired
    private ObservacionDtoConverter observacionDtoConverter = new ObservacionDtoConverter();
    @Autowired
    private ClasificacionIncidenteDtoConverter clasificacionIncidenteDtoConverter = new ClasificacionIncidenteDtoConverter();


    public IncidenteDTO convert(final Incidente source ) {
        final IncidenteDTO target = IncidenteDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        target.setObservaciones(Optional.ofNullable(source.getObservaciones()).map( t-> t.stream().map( o-> observacionDtoConverter.convert(o)).toList()).orElse(null));
        if ( source.getClasificacionIncidente() != null ) {
            target.setClasificacionIncidente(clasificacionIncidenteDtoConverter.convert(source.getClasificacionIncidente()));
        }
        return target;
    }
}
