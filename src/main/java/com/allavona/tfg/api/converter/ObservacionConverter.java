package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Observacion;
import com.allavona.tfg.business.dto.ObservacionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
// Se utiliza la implementación de la clase Converter de spring para facilitar
// el uso de varios converters desde la clase en la que sean necesarios sin tener que instanciar uno de cada
// tipo.
public class ObservacionConverter implements Converter<ObservacionDTO, Observacion> {
    // Dentro de una clase que implemente el Converter de Spring no puede instanciarse otro Converter,
    // porque da problemas por referencia cíclica, así que en este caso debemos instanciar el Converter
    // específico.
    private final UsuarioConverter usuarioConverter;

    public ObservacionConverter(UsuarioConverter usuarioConverter) {
        this.usuarioConverter = usuarioConverter;
    }
    // Método que realiza la transformación de un objeto de tipo DTO a tipo VO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public Observacion convert(final ObservacionDTO source ) {
        final Observacion target = Observacion.builder().build();
        BeanUtils.copyProperties(source, target);
        // Como usuario es un objeto, debemos realizar su conversión específicamente, ya que el copyProperties
        // no la realiza
        if ( source.getUsuario() != null ) {
            target.setUsuario(usuarioConverter.convert(source.getUsuario()));
        }
        return target;
    }
}
