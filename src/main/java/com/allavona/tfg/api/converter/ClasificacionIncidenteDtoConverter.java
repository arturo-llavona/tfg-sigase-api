package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.ClasificacionIncidente;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
// Se utiliza la implementación de la clase Converter de spring para facilitar
// el uso de varios converters desde la clase en la que sean necesarios sin tener que instanciar uno de cada
// tipo.
public class ClasificacionIncidenteDtoConverter implements Converter<ClasificacionIncidente, ClasificacionIncidenteDTO> {
    // Método que realiza la transformación de un objeto de tipo VO a tipo DTO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public ClasificacionIncidenteDTO convert(final ClasificacionIncidente source ) {
        final ClasificacionIncidenteDTO target = ClasificacionIncidenteDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
