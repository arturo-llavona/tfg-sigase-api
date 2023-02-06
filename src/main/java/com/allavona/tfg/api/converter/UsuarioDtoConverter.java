package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoConverter implements Converter<Usuario, UsuarioDTO> {
    public UsuarioDTO convert(final Usuario source) {
        final UsuarioDTO target = UsuarioDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
