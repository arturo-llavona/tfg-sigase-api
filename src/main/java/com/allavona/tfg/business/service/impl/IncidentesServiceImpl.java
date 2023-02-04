package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.IncidenteListadoEntity;
import com.allavona.tfg.business.bbdd.entity.RecursoIncidenteListadoEntity;
import com.allavona.tfg.business.bbdd.entity.base.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.base.IncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.RecursoEstadoCompletoEntity;
import com.allavona.tfg.business.bbdd.repository.IncidenteListadoRepository;
import com.allavona.tfg.business.bbdd.repository.RecursosIncidenteListadoRepository;
import com.allavona.tfg.business.bbdd.repository.base.ClasificacionIncidenteRepository;
import com.allavona.tfg.business.bbdd.repository.base.IncidenteRepository;
import com.allavona.tfg.business.bbdd.repository.RecursosIncidenteRepository;
import com.allavona.tfg.business.converter.*;
import com.allavona.tfg.business.dto.*;
import com.allavona.tfg.business.service.IncidentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class IncidentesServiceImpl implements IncidentesService {
    @Autowired
    private ClasificacionIncidenteRepository clasificacionIncidenteRepository;

    @Autowired
    private IncidenteListadoRepository incidenteListadoRepository;

    @Autowired
    private RecursosIncidenteListadoRepository recursosIncidenteListadoRepository;

    private ClasificacionIncidenteEntityConverter clasificacionIncidenteEntityConverter = new ClasificacionIncidenteEntityConverter();

    private IncidenteEntityConverter incidenteEntityConverter = new IncidenteEntityConverter();

    private RecursoEstadoCompletoEntityConverter recursoEstadoCompletoEntityConverter = new RecursoEstadoCompletoEntityConverter();

    private IncidenteListadoEntityConverter incidenteListadoEntityConverter = new IncidenteListadoEntityConverter();

    private RecursoIncidenteListadoEntityConverter recursoIncidenteListadoEntityConverter = new RecursoIncidenteListadoEntityConverter();

    @Override
    public List<ClasificacionIncidenteDTO> findClasificacionIncidenteByCodigo(final String codigo) {
        List<ClasificacionIncidenteEntity> source =  clasificacionIncidenteRepository.findByCodigoStartingWith(codigo);
        List<ClasificacionIncidenteDTO> target = source.stream().map(recurso -> clasificacionIncidenteEntityConverter.convert(recurso)).toList();
        return target;
    }

    @Override
    public List<IncidenteListadoDTO> findIncidentesEnCurso() {
        List<IncidenteListadoEntity> source = incidenteListadoRepository.findIncidenteEnCursoListado();
        List<IncidenteListadoDTO> incidentes = source.stream().map(x -> incidenteListadoEntityConverter.convert(x)).toList();
        incidentes.forEach( incidente -> {
            List<RecursoIncidenteListadoEntity> recursoIncidenteListadoEntities = recursosIncidenteListadoRepository.findRecursosIncidente(incidente.getIdIncidente());
            List<RecursoIncidenteListadoDTO> recursoIncidenteListadoDTOS = recursoIncidenteListadoEntities.stream().map(x -> recursoIncidenteListadoEntityConverter.convert(x)).toList();
            incidente.setRecursos(recursoIncidenteListadoDTOS);
        });
        return incidentes;
    }

    @Override
    public List<IncidenteListadoDTO> findIncidentesFinalizados() {
        List<IncidenteListadoEntity> source = incidenteListadoRepository.findIncidenteFinalizadoListado();
        List<IncidenteListadoDTO> incidentes = source.stream().map(x -> incidenteListadoEntityConverter.convert(x)).toList();
        incidentes.forEach( incidente -> {
            List<RecursoIncidenteListadoEntity> recursoIncidenteListadoEntities = recursosIncidenteListadoRepository.findRecursosIncidente(incidente.getIdIncidente());
            List<RecursoIncidenteListadoDTO> recursoIncidenteListadoDTOS = recursoIncidenteListadoEntities.stream().map(x -> recursoIncidenteListadoEntityConverter.convert(x)).toList();
            incidente.setRecursos(recursoIncidenteListadoDTOS);
        });
        return incidentes;
    }
}
