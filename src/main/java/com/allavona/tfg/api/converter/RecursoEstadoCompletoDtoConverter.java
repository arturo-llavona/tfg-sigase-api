package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.api.vo.RecursoEstadoCompleto;
import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.dto.RecursoEstadoCompletoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecursoEstadoCompletoDtoConverter {

    public RecursoEstadoCompleto convert(final RecursoEstadoCompletoDTO source ) {
        final RecursoEstadoCompleto target = new RecursoEstadoCompleto();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
