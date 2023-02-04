package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.api.vo.RecursoIncidenteListado;
import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.dto.RecursoIncidenteListadoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecursoIncidenteListadoDtoConverter {

    public RecursoIncidenteListado convert(final RecursoIncidenteListadoDTO source ) {
        final RecursoIncidenteListado target = new RecursoIncidenteListado();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
