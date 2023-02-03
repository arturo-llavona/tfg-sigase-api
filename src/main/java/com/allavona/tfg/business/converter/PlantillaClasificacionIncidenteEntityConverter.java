package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.PlantillaClasificacionIncidenteEntity;
import com.allavona.tfg.business.dto.PlantillaClasificacionIncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlantillaClasificacionIncidenteEntityConverter {
    @Autowired
    private TipoRecursoEntityConverter tipoRecursoEntityConverter = new TipoRecursoEntityConverter();

    @Autowired
    private ClasificacionIncidenteEntityConverter clasificacionIncidenteEntityConverter = new ClasificacionIncidenteEntityConverter();

    public PlantillaClasificacionIncidenteDTO convert(final PlantillaClasificacionIncidenteEntity source ) {
        final PlantillaClasificacionIncidenteDTO target = new PlantillaClasificacionIncidenteDTO();
        BeanUtils.copyProperties(source, target);
        target.setTipoRecurso(tipoRecursoEntityConverter.convert(source.getTipoRecurso()));
        target.setClasificacionIncidente(clasificacionIncidenteEntityConverter.convert(source.getClasificacionIncidente()));
        return target;
    }
}
