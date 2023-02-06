package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.IncidentePersonaAfectada;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.dto.IncidentePersonaAfectadaDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IncidentePersonaAfectadaConverter implements Converter<IncidentePersonaAfectadaDTO, IncidentePersonaAfectada> {
    public IncidentePersonaAfectada convert(final IncidentePersonaAfectadaDTO source ) {
        final IncidentePersonaAfectada target = IncidentePersonaAfectada.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
