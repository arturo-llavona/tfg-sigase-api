package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.IncidentePersonaAfectadaEntity;
import com.allavona.tfg.business.dto.IncidentePersonaAfectadaDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class IncidentePersonaAfectadaEntityConverter {
    // Método que realiza la transformación de un objeto de tipo Entity a tipo DTO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public IncidentePersonaAfectadaEntity convert(final IncidentePersonaAfectadaDTO source ) {
        final IncidentePersonaAfectadaEntity target = new IncidentePersonaAfectadaEntity();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
