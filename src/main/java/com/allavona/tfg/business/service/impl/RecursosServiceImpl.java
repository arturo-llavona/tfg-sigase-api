package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.bbdd.entity.TipoRecursoEntity;
import com.allavona.tfg.business.bbdd.repository.RecursoRepository;
import com.allavona.tfg.business.bbdd.repository.TipoRecursoRepository;
import com.allavona.tfg.business.converter.RecursoEntityConverter;
import com.allavona.tfg.business.converter.TipoRecursoEntityConverter;
import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import com.allavona.tfg.business.service.RecursosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursosServiceImpl implements RecursosService {
    private final RecursoRepository recursoRepository;
    private final TipoRecursoRepository tipoRecursoRepository;
    private RecursoEntityConverter recursoEntityConverter = new RecursoEntityConverter();
    private TipoRecursoEntityConverter tipoRecursoEntityConverter = new TipoRecursoEntityConverter();
    public RecursosServiceImpl(RecursoRepository recursoRepository, TipoRecursoRepository tipoRecursoRepository) {
        this.recursoRepository = recursoRepository;
        this.tipoRecursoRepository = tipoRecursoRepository;
    }
    @Override
    public List<RecursoDTO> findAll(final Integer idTipoRecurso) {
        // Se realiza una consulta a la base de datos, dependiendo de si nos llega indicado un idTipoRecurso en el parámetro
        // o no. En caso de llegar, se realiza una búsqueda de todos los recursos habilitados del tipo de recurso indicado,
        // en caso contrario, se realiza una búsqueda de todos los recursos habilitados, independientemente del tipo.
        List<RecursoEntity> source =  idTipoRecurso != null ? recursoRepository.findRecursosHabilitados(idTipoRecurso) : recursoRepository.findRecursosHabilitados();
        // Después, realizamos la transformación del listado de Entity a DTO utilizando su converter.
        List<RecursoDTO> recursos = source.stream().map(recurso -> recursoEntityConverter.convert(recurso)).toList();
        return recursos;
    }
    @Override
    public List<RecursoDTO> findRecursosDisponibles(final Integer idTipoRecurso) {
        // Se realiza una consulta a la base de datos, dependiendo de si nos llega indicado un idTipoRecurso en el parámetro
        // o no. En caso de llegar, se realiza una búsqueda de todos los recursos disponibles del tipo de recurso indicado,
        // en caso contrario, se realiza una búsqueda de todos los recursos disponibles, independientemente del tipo.
        List<RecursoEntity> source = idTipoRecurso != null ? recursoRepository.findRecursosDisponibles(idTipoRecurso) : recursoRepository.findRecursosDisponibles();
        // Después, realizamos la transformación del listado de Entity a DTO utilizando su converter.
        List<RecursoDTO> recursos = source.stream().map(recurso -> recursoEntityConverter.convert(recurso)).toList();
        return recursos;
    }
    @Override
    public List<TipoRecursoDTO> listResourcesByIncidentClassification(Integer idClasificacionIncidente) {
        // Se realiza una consulta a base de datos para obtener todos los tipos de recurso recomendados para una
        // clasificación de incidente determinada.
        List<TipoRecursoEntity> source =  tipoRecursoRepository.listResourcesByIncidentClassification(idClasificacionIncidente);
        // Después, realizamos la transformación del listado de Entity a DTO utilizando su converter.
        List<TipoRecursoDTO> target = source.stream().map(tipoRecurso -> tipoRecursoEntityConverter.convert(tipoRecurso)).toList();
        return target;
    }
}
