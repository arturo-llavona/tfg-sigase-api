package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.Incidente;
import com.allavona.tfg.business.dto.IncidenteDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
// Se utiliza la implementación de la clase Converter de spring para facilitar
// el uso de varios converters desde la clase en la que sean necesarios sin tener que instanciar uno de cada
// tipo.
public class IncidenteConverter implements Converter<IncidenteDTO, Incidente> {
    // Dentro de una clase que implemente el Converter de Spring no puede instanciarse otro Converter,
    // porque da problemas por referencia cíclica, así que en este caso debemos instanciar los Converters
    // específicos.
    private final ObservacionConverter observacionConverter;
    private final ClasificacionIncidenteConverter clasificacionIncidenteConverter;
    private final IncidentePersonaAfectadaConverter incidentePersonaAfectadaConverter;
    private final TipoRecursoConverter tipoRecursoConverter;
    private final RecursoConverter recursoConverter;

    public IncidenteConverter(ObservacionConverter observacionConverter, ClasificacionIncidenteConverter clasificacionIncidenteConverter,
                              IncidentePersonaAfectadaConverter incidentePersonaAfectadaConverter, TipoRecursoConverter tipoRecursoConverter,
                              RecursoConverter recursoConverter) {
        this.observacionConverter = observacionConverter;
        this.clasificacionIncidenteConverter = clasificacionIncidenteConverter;
        this.incidentePersonaAfectadaConverter = incidentePersonaAfectadaConverter;
        this.tipoRecursoConverter = tipoRecursoConverter;
        this.recursoConverter = recursoConverter;
    }

    // Método que realiza la transformación de un objeto de tipo DTO a tipo VO, basado en la funcionalidad
    // copyProperties de BeanUtils.
    public Incidente convert(final IncidenteDTO source ) {
        final Incidente target = Incidente.builder().build();
        BeanUtils.copyProperties(source, target);
        // Como estos atributos son objetos, debemos realizar su conversión específicamente, ya que el copyProperties
        // no la realiza
        if ( source.getPersonaAfectada() != null ) {
            target.setPersonaAfectada(incidentePersonaAfectadaConverter.convert(source.getPersonaAfectada()));
        }
        if ( source.getClasificacionIncidente() != null ) {
            target.setClasificacionIncidente(clasificacionIncidenteConverter.convert(source.getClasificacionIncidente()));
        }
        target.setPlantillaRecursos(Optional.ofNullable(source.getPlantillaRecursos()).map( t-> t.stream().map( o-> tipoRecursoConverter.convert(o)).toList()).orElse(null));
        target.setRecursos(Optional.ofNullable(source.getRecursos()).map( t-> t.stream().map( o-> recursoConverter.convert(o)).toList()).orElse(null));
        target.setObservaciones(Optional.ofNullable(source.getObservaciones()).map( t-> t.stream().map( o-> observacionConverter.convert(o)).toList()).orElse(null));
        return target;
    }
}
