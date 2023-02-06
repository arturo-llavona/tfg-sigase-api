package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Observacion;
import com.allavona.tfg.business.dto.ObservacionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ObservacionConverter implements Converter<ObservacionDTO, Observacion> {
    private final UsuarioConverter usuarioConverter;

    public ObservacionConverter(UsuarioConverter usuarioConverter) {
        this.usuarioConverter = usuarioConverter;
    }

    public Observacion convert(final ObservacionDTO source ) {
        final Observacion target = Observacion.builder().build();
        BeanUtils.copyProperties(source, target);
        if ( source.getUsuario() != null ) {
            target.setUsuario(usuarioConverter.convert(source.getUsuario()));
        }
        return target;
    }
}
