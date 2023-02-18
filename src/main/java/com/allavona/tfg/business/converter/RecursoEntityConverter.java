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

    // Método que realiza la transformación de un objeto de tipo Entity a tipo DTO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public RecursoDTO convert(final RecursoEntity source ) {
        final RecursoDTO target = RecursoDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        // Como tipoRecurso es un objeto, debemos realizar su conversión específicamente, ya que el copyProperties
        // no la realiza
        target.setTipoRecurso(tipoRecursoEntityConverter.convert(source.getTipoRecurso()));
        return target;
    }
}
