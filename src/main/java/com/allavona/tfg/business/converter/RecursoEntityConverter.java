package com.allavona.tfg.business.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.dto.RecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class RecursoEntityConverter {
    @Autowired
    private TipoRecursoEntityConverter tipoRecursoDtoConverter = new TipoRecursoEntityConverter();
    public RecursoDTO convert(final RecursoEntity source ) {
        final RecursoDTO target = new RecursoDTO();
        BeanUtils.copyProperties(source, target);
        target.setTipoRecurso(tipoRecursoDtoConverter.convert(source.getTipoRecurso()));
        return target;
    }
}
