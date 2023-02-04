package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.IncidenteListado;
import com.allavona.tfg.api.vo.RecursoEstadoCompleto;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteListadoDTO;
import com.allavona.tfg.business.dto.RecursoEstadoCompletoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncidenteListadoDtoConverter {
    @Autowired
    private RecursoIncidenteListadoDtoConverter recursoIncidenteListadoDtoConverter = new RecursoIncidenteListadoDtoConverter();

    public IncidenteListado convert(final IncidenteListadoDTO source ) {
        final IncidenteListado target = new IncidenteListado();
        BeanUtils.copyProperties(source, target);
        target.setRecursos(source.getRecursos().stream().map(x -> recursoIncidenteListadoDtoConverter.convert(x)).toList());
        return target;
    }
}
