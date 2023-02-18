package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.dto.RecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
// Se utiliza la implementación de la clase Converter de spring para facilitar
// el uso de varios converters desde la clase en la que sean necesarios sin tener que instanciar uno de cada
// tipo.
public class RecursoDtoConverter implements Converter<Recurso, RecursoDTO>  {
    // Dentro de una clase que implemente el Converter de Spring no puede instanciarse otro Converter,
    // porque da problemas por referencia cíclica, así que en este caso debemos instanciar el Converter
    // específico.
    private final TipoRecursoDtoConverter tipoRecursoDtoConverter;

    public RecursoDtoConverter(TipoRecursoDtoConverter tipoRecursoDtoConverter) {
        this.tipoRecursoDtoConverter = tipoRecursoDtoConverter;
    }
    // Método que realiza la transformación de un objeto de tipo VO a tipo DTO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public RecursoDTO convert(final Recurso source ) {
        final RecursoDTO target = RecursoDTO.builder().build();
        BeanUtils.copyProperties(source, target);
        // Como tipoRecurso es un objeto, debemos realizar su conversión específicamente, ya que el copyProperties
        // no la realiza
        if ( source.getTipoRecurso() != null ) {
            target.setTipoRecurso(tipoRecursoDtoConverter.convert(source.getTipoRecurso()));
        }
        return target;
    }
}
