package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IncidenteDtoConverter {
    @Autowired
    private ObservacionDtoConverter observacionDtoConverter = new ObservacionDtoConverter();
    public Incidente convert(final IncidenteDTO source ) {
        final Incidente target = Incidente.builder().build();
        BeanUtils.copyProperties(source, target);
        target.setObservaciones(Optional.ofNullable(source.getObservaciones()).map( t-> t.stream().map( o-> observacionDtoConverter.convert(o)).toList()).orElse(null));
        return target;
    }
}
