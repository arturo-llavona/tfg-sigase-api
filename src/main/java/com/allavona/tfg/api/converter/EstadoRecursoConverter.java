package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.EstadoRecurso;
import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.business.dto.EstadoRecursoDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EstadoRecursoConverter implements Converter<EstadoRecursoDTO, EstadoRecurso> {
    public EstadoRecurso convert(final EstadoRecursoDTO source ) {
        final EstadoRecurso target = EstadoRecurso.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
