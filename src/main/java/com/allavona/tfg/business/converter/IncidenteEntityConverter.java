package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class IncidenteEntityConverter {
    // Método que realiza la transformación de un objeto de tipo Entity a tipo DTO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public IncidenteEntity convert(final IncidenteDTO source ) {
        final IncidenteEntity target = new IncidenteEntity();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
