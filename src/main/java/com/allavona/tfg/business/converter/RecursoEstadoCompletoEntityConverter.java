package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.RecursoEstadoCompletoEntity;
import com.allavona.tfg.business.dto.RecursoEstadoCompletoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RecursoEstadoCompletoEntityConverter {

    public RecursoEstadoCompletoDTO convert(final RecursoEstadoCompletoEntity source ) {
        final RecursoEstadoCompletoDTO target = new RecursoEstadoCompletoDTO();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
