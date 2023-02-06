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

    public RecursosServiceImpl(RecursoRepository recursoRepository, TipoRecursoRepository tipoRecursoRepository) {
        this.recursoRepository = recursoRepository;
        this.tipoRecursoRepository = tipoRecursoRepository;
    }

    private RecursoEntityConverter recursoEntityConverter = new RecursoEntityConverter();

    private TipoRecursoEntityConverter tipoRecursoEntityConverter = new TipoRecursoEntityConverter();

    @Override
    public List<RecursoDTO> findAll(final Integer idTipoRecurso) {
        List<RecursoEntity> source =  idTipoRecurso != null ? recursoRepository.findRecursosHabilitados(idTipoRecurso) : recursoRepository.findRecursosHabilitados();
        List<RecursoDTO> recursos = source.stream().map(recurso -> recursoEntityConverter.convert(recurso)).toList();
        return recursos;
    }

    @Override
    public List<RecursoDTO> findRecursosDisponibles(final Integer idTipoRecurso) {
        List<RecursoEntity> source = idTipoRecurso != null ? recursoRepository.findRecursosDisponibles(idTipoRecurso) : recursoRepository.findRecursosDisponibles();
        List<RecursoDTO> recursos = source.stream().map(recurso -> recursoEntityConverter.convert(recurso)).toList();
        return recursos;
    }

    @Override
    public List<TipoRecursoDTO> listResourcesByIncidentClassification(Integer idClasificacionIncidente) {
        List<TipoRecursoEntity> source =  tipoRecursoRepository.listResourcesByIncidentClassification(idClasificacionIncidente);
        List<TipoRecursoDTO> target = source.stream().map(tipoRecurso -> tipoRecursoEntityConverter.convert(tipoRecurso)).toList();
        return target;
    }
}
