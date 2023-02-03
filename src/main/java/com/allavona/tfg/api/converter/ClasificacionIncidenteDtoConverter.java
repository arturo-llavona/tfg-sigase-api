package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.ClasificacionIncidente;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClasificacionIncidenteDtoConverter {

    public ClasificacionIncidente convert(final ClasificacionIncidenteDTO source ) {
        final ClasificacionIncidente target = new ClasificacionIncidente();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
