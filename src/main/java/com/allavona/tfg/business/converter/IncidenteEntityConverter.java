package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncidenteEntityConverter {
    @Autowired
    private ClasificacionIncidenteEntityConverter converter = new ClasificacionIncidenteEntityConverter();

    public IncidenteDTO convert(final IncidenteEntity source ) {
        final IncidenteDTO target = new IncidenteDTO();
        BeanUtils.copyProperties(source, target);
        target.setClasificacionIncidente(converter.convert(source.getClasificacionIncidente()));
        return target;
    }
}
