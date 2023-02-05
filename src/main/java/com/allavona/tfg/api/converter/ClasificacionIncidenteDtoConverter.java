package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.ClasificacionIncidente;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClasificacionIncidenteDtoConverter {
    public ClasificacionIncidente convert(final ClasificacionIncidenteDTO source ) {
        final ClasificacionIncidente target = ClasificacionIncidente.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public ClasificacionIncidenteDTO convert(final ClasificacionIncidente source ) {
        final ClasificacionIncidenteDTO target = ClasificacionIncidenteDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
