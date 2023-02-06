package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter implements Converter<UsuarioDTO, Usuario> {
    public Usuario convert(final UsuarioDTO source ) {
        final Usuario target = Usuario.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
