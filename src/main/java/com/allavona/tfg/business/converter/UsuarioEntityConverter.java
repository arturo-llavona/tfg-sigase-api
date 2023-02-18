package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityConverter {
    // Método que realiza la transformación de un objeto de tipo Entity a tipo DTO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public UsuarioDTO convert(final UsuarioEntity source) {
        final UsuarioDTO target = UsuarioDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
