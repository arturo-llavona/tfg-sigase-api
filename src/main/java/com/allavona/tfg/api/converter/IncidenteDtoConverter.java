package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.api.vo.RecursoEstadoCompleto;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.dto.RecursoEstadoCompletoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncidenteDtoConverter {
    @Autowired
    private ClasificacionIncidenteDtoConverter clasificacionIncidenteDtoConverter = new ClasificacionIncidenteDtoConverter();
    @Autowired
    private RecursoEstadoCompletoDtoConverter recursoEstadoCompletoDtoConverter = new RecursoEstadoCompletoDtoConverter();

    public Incidente convert(final IncidenteDTO source ) {
        final Incidente target = new Incidente();
        BeanUtils.copyProperties(source, target);
        target.setClasificacionIncidente(clasificacionIncidenteDtoConverter.convert(source.getClasificacionIncidente()));
        List<RecursoEstadoCompletoDTO> e1 = source.getRecursoEstadoCompleto();
        List<RecursoEstadoCompleto> e2 = e1.stream().map(e -> recursoEstadoCompletoDtoConverter.convert(e)).toList();
        target.setRecursos(e2);
        return target;
    }
}
