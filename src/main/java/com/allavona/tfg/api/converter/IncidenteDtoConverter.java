package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import com.allavona.tfg.business.converter.ClasificacionIncidenteEntityConverter;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncidenteDtoConverter {
    @Autowired
    private ClasificacionIncidenteDtoConverter converter = new ClasificacionIncidenteDtoConverter();

    public Incidente convert(final IncidenteDTO source ) {
        final Incidente target = new Incidente();
        BeanUtils.copyProperties(source, target);
        target.setClasificacionIncidente(converter.convert(source.getClasificacionIncidente()));
        return target;
    }
}
