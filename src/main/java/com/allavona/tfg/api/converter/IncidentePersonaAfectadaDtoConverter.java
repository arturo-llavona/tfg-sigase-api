package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.IncidentePersonaAfectada;
import com.allavona.tfg.business.dto.IncidentePersonaAfectadaDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IncidentePersonaAfectadaDtoConverter implements Converter<IncidentePersonaAfectada, IncidentePersonaAfectadaDTO> {
    public IncidentePersonaAfectadaDTO convert(final IncidentePersonaAfectada source ) {
        final IncidentePersonaAfectadaDTO target = IncidentePersonaAfectadaDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
