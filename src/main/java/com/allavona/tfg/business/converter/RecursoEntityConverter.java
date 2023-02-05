package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.dto.RecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecursoEntityConverter {
    @Autowired
    private TipoRecursoEntityConverter tipoRecursoEntityConverter = new TipoRecursoEntityConverter();

    public RecursoDTO convert(final RecursoEntity source ) {
        final RecursoDTO target = RecursoDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        target.setTipoRecurso(tipoRecursoEntityConverter.convert(source.getTipoRecurso()));
        return target;
    }
}
