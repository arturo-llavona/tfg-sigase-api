package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
// Se utiliza la implementación de la clase Converter de spring para facilitar
// el uso de varios converters desde la clase en la que sean necesarios sin tener que instanciar uno de cada
// tipo.
public class UsuarioDtoConverter implements Converter<Usuario, UsuarioDTO> {
    // Método que realiza la transformación de un objeto de tipo VO a tipo DTO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public UsuarioDTO convert(final Usuario source) {
        final UsuarioDTO target = UsuarioDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
