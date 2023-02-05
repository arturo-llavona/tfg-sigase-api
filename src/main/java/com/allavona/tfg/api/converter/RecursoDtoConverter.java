package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.dto.RecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecursoDtoConverter {
    @Autowired
    private TipoRecursoDtoConverter tipoRecursoDtoConverter = new TipoRecursoDtoConverter();
    public Recurso convert(final RecursoDTO source ) {
        final Recurso target = Recurso.builder().build();
        BeanUtils.copyProperties(source, target);
        target.setTipoRecurso(tipoRecursoDtoConverter.convert(source.getTipoRecurso()));
        return target;
    }
}
