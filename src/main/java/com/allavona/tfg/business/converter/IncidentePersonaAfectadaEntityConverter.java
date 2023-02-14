package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.IncidentePersonaAfectadaEntity;
import com.allavona.tfg.business.dto.IncidentePersonaAfectadaDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class IncidentePersonaAfectadaEntityConverter {
    public IncidentePersonaAfectadaEntity convert(final IncidentePersonaAfectadaDTO source ) {
        final IncidentePersonaAfectadaEntity target = new IncidentePersonaAfectadaEntity();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
