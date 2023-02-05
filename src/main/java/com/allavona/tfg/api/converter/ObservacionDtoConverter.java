package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Observacion;
import com.allavona.tfg.business.dto.ObservacionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObservacionDtoConverter {
    @Autowired
    private UsuarioDtoConverter usuarioDtoConverter = new UsuarioDtoConverter();
    public Observacion convert(final ObservacionDTO source ) {
        final Observacion target = Observacion.builder().build();
        BeanUtils.copyProperties(source, target);
        if ( source.getUsuario() != null ) {
            target.setUsuario(usuarioDtoConverter.convert(source.getUsuario()));
        }
        return target;
    }
    public ObservacionDTO convert(final Observacion source ) {
        final ObservacionDTO target = ObservacionDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        if ( source.getUsuario() != null ) {
            target.setUsuario(usuarioDtoConverter.convert(source.getUsuario()));
        }
        return target;
    }
}
