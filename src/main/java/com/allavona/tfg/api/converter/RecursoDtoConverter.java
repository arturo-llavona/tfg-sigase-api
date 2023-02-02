package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.bbdd.repository.RecursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class RecursoDtoConverter {
    @Autowired
    private TipoRecursoDtoConverter tipoRecursoDtoConverter = new TipoRecursoDtoConverter();
    public Recurso convert(final RecursoEntity source ) {
        final Recurso target = new Recurso();
        BeanUtils.copyProperties(source, target);
        target.setTipoRecurso(tipoRecursoDtoConverter.convert(source.getTipoRecurso()));
        return target;
    }
}
