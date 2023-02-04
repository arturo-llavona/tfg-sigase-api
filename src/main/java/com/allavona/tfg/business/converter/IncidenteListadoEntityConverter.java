package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.IncidenteListadoEntity;
import com.allavona.tfg.business.bbdd.entity.base.UsuarioEntity;
import com.allavona.tfg.business.dto.IncidenteListadoDTO;
import com.allavona.tfg.business.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class IncidenteListadoEntityConverter {

    public IncidenteListadoDTO convert(final IncidenteListadoEntity source) {
        final IncidenteListadoDTO target = new IncidenteListadoDTO();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
