package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Login;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoConverter {
    public Usuario convert(final UsuarioDTO source ) {
        final Usuario target = Usuario.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
    public UsuarioDTO convert(final Login source) {
        final UsuarioDTO target = UsuarioDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }

}
