package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.base.RecursoEntity;
import com.allavona.tfg.business.bbdd.entity.base.TipoRecursoEntity;
import com.allavona.tfg.business.bbdd.repository.base.RecursoRepository;
import com.allavona.tfg.business.bbdd.repository.base.TipoRecursoRepository;
import com.allavona.tfg.business.converter.RecursoEntityConverter;
import com.allavona.tfg.business.converter.TipoRecursoEntityConverter;
import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.dto.TipoRecursoDTO;
import com.allavona.tfg.business.service.RecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursosServiceImpl implements RecursosService {
    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private TipoRecursoRepository tipoRecursoRepository;

    private RecursoEntityConverter recursoEntityConverter = new RecursoEntityConverter();

    private TipoRecursoEntityConverter tipoRecursoEntityConverter = new TipoRecursoEntityConverter();

    @Override
    public List<RecursoDTO> findAll() {
        List<RecursoEntity> source =  recursoRepository.findByHabilitadoTrue();
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
