package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.IncidentePersonaAfectada;
import com.allavona.tfg.business.dto.IncidentePersonaAfectadaDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
// Se utiliza la implementación de la clase Converter de spring para facilitar
// el uso de varios converters desde la clase en la que sean necesarios sin tener que instanciar uno de cada
// tipo.
public class IncidentePersonaAfectadaConverter implements Converter<IncidentePersonaAfectadaDTO, IncidentePersonaAfectada> {
    // Método que realiza la transformación de un objeto de tipo DTO a tipo VO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public IncidentePersonaAfectada convert(final IncidentePersonaAfectadaDTO source ) {
        final IncidentePersonaAfectada target = IncidentePersonaAfectada.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
