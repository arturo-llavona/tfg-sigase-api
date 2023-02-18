package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.TipoRecursoEntity;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TipoRecursoEntityConverter {
    // Método que realiza la transformación de un objeto de tipo Entity a tipo DTO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public TipoRecursoDTO convert(final TipoRecursoEntity source ) {
        final TipoRecursoDTO target = TipoRecursoDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
