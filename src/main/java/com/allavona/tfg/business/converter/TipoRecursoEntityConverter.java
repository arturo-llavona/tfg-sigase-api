package com.allavona.tfg.business.converter;

import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.business.bbdd.entity.TipoRecursoEntity;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import org.springframework.beans.BeanUtils;

public class TipoRecursoEntityConverter {

    public TipoRecursoDTO convert(final TipoRecursoEntity source ) {
        final TipoRecursoDTO target = new TipoRecursoDTO();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
