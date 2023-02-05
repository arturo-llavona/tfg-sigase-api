package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClasificacionIncidenteEntityConverter {
    public ClasificacionIncidenteDTO convert(final ClasificacionIncidenteEntity source ) {
        final ClasificacionIncidenteDTO target = ClasificacionIncidenteDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
    public ClasificacionIncidenteEntity convert(final ClasificacionIncidenteDTO source ) {
        final ClasificacionIncidenteEntity target = new ClasificacionIncidenteEntity();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
