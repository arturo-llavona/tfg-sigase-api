package com.allavona.tfg.business.converter;

import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import com.allavona.tfg.business.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityConverter {

    public UsuarioDTO convert(final UsuarioEntity source) {
        final UsuarioDTO target = new UsuarioDTO();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
