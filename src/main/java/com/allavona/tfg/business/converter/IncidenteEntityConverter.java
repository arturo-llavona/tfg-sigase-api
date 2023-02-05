package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class IncidenteEntityConverter {
    public IncidenteEntity convert(final IncidenteDTO source ) {
        final IncidenteEntity target = new IncidenteEntity();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
