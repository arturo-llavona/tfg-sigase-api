package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.dto.RecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecursoDtoConverter implements Converter<Recurso, RecursoDTO>  {
    private final TipoRecursoDtoConverter tipoRecursoDtoConverter;

    public RecursoDtoConverter(TipoRecursoDtoConverter tipoRecursoDtoConverter) {
        this.tipoRecursoDtoConverter = tipoRecursoDtoConverter;
    }

    public RecursoDTO convert(final Recurso source ) {
        final RecursoDTO target = RecursoDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        if ( source.getTipoRecurso() != null ) {
            target.setTipoRecurso(tipoRecursoDtoConverter.convert(source.getTipoRecurso()));
        }
        return target;
    }
}
