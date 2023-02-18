package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.dto.RecursoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
// Se utiliza la implementación de la clase Converter de spring para facilitar
// el uso de varios converters desde la clase en la que sean necesarios sin tener que instanciar uno de cada
// tipo.
public class RecursoConverter implements Converter<RecursoDTO, Recurso>  {
    // Dentro de una clase que implemente el Converter de Spring no puede instanciarse otro Converter,
    // porque da problemas por referencia cíclica, así que en este caso debemos instanciar los Converters
    // específicos.
    private final TipoRecursoConverter tipoRecursoConverter;
    private final EstadoRecursoConverter estadoRecursoConverter;
    public RecursoConverter(TipoRecursoConverter tipoRecursoConverter, EstadoRecursoConverter estadoRecursoConverter) {
        this.tipoRecursoConverter = tipoRecursoConverter;
        this.estadoRecursoConverter = estadoRecursoConverter;
    }
    // Método que realiza la transformación de un objeto de tipo DTO a tipo VO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public Recurso convert(final RecursoDTO source ) {
        final Recurso target = Recurso.builder().build();
        BeanUtils.copyProperties(source, target);
        // Como tipoRecurso es un objeto, debemos realizar su conversión específicamente, ya que el copyProperties
        // no la realiza
        if ( source.getTipoRecurso() != null ) {
            target.setTipoRecurso(tipoRecursoConverter.convert(source.getTipoRecurso()));
        }
        // Como estado es un objeto, debemos realizar su conversión específicamente, ya que el copyProperties
        // no la realiza
        if ( source.getEstado() != null ) {
            target.setEstado(estadoRecursoConverter.convert(source.getEstado()));
        }
        return target;
    }
}
