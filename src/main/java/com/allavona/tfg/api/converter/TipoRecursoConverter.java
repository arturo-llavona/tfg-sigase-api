package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TipoRecursoConverter implements Converter<TipoRecursoDTO, TipoRecurso> {
    public TipoRecurso convert(final TipoRecursoDTO source ) {
        final TipoRecurso target = TipoRecurso.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
