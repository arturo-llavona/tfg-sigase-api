package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.base.TipoRecursoEntity;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TipoRecursoEntityConverter {

    public TipoRecursoDTO convert(final TipoRecursoEntity source ) {
        final TipoRecursoDTO target = new TipoRecursoDTO();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
