package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.bbdd.entity.TipoRecursoEntity;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import org.springframework.beans.BeanUtils;

public class TipoRecursoDtoConverter {

    public TipoRecurso convert(final TipoRecursoDTO source ) {
        final TipoRecurso target = new TipoRecurso();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
