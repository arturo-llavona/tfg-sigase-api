package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.IncidenteListadoEntity;
import com.allavona.tfg.business.bbdd.entity.RecursoIncidenteListadoEntity;
import com.allavona.tfg.business.dto.IncidenteListadoDTO;
import com.allavona.tfg.business.dto.RecursoIncidenteListadoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RecursoIncidenteListadoEntityConverter {

    public RecursoIncidenteListadoDTO convert(final RecursoIncidenteListadoEntity source) {
        final RecursoIncidenteListadoDTO target = new RecursoIncidenteListadoDTO();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
