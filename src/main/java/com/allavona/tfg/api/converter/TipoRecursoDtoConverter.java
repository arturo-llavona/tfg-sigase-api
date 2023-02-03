package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TipoRecursoDtoConverter {
    public TipoRecurso convert(final TipoRecursoDTO source ) {
        final TipoRecurso target = new TipoRecurso();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
