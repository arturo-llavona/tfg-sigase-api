package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.ClasificacionIncidente;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClasificacionIncidenteConverter implements Converter<ClasificacionIncidenteDTO, ClasificacionIncidente> {
    public ClasificacionIncidente convert(final ClasificacionIncidenteDTO source ) {
        final ClasificacionIncidente target = ClasificacionIncidente.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
