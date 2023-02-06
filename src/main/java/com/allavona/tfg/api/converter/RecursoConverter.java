package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.dto.RecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecursoConverter implements Converter<RecursoDTO, Recurso>  {
    private final TipoRecursoConverter tipoRecursoConverter;

    public RecursoConverter(TipoRecursoConverter tipoRecursoConverter) {
        this.tipoRecursoConverter = tipoRecursoConverter;
    }

    public Recurso convert(final RecursoDTO source ) {
        final Recurso target = Recurso.builder().build();
        BeanUtils.copyProperties(source, target);
        if ( source.getTipoRecurso() != null ) {
            target.setTipoRecurso(tipoRecursoConverter.convert(source.getTipoRecurso()));
        }
        return target;
    }
}
