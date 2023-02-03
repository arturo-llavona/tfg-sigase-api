package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.entity.IncidenteEntity;
import com.allavona.tfg.business.bbdd.repository.ClasificacionIncidenteRepository;
import com.allavona.tfg.business.bbdd.repository.IncidenteRepository;
import com.allavona.tfg.business.converter.ClasificacionIncidenteEntityConverter;
import com.allavona.tfg.business.converter.IncidenteEntityConverter;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.dto.IncidenteDTO;
import com.allavona.tfg.business.service.IncidentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentesServiceImpl implements IncidentesService {
    @Autowired
    private ClasificacionIncidenteRepository clasificacionIncidenteRepository;

    @Autowired
    private IncidenteRepository incidenteRepository;

    private ClasificacionIncidenteEntityConverter clasificacionIncidenteEntityConverter = new ClasificacionIncidenteEntityConverter();

    private IncidenteEntityConverter incidenteEntityConverter = new IncidenteEntityConverter();

    @Override
    public List<ClasificacionIncidenteDTO> findByCodigo(final String codigo) {
        List<ClasificacionIncidenteEntity> source =  clasificacionIncidenteRepository.findByCodigoStartingWith(codigo);
        List<ClasificacionIncidenteDTO> target = source.stream().map(recurso -> clasificacionIncidenteEntityConverter.convert(recurso)).toList();
        return target;
    }

    @Override
    public List<IncidenteDTO> findIncidentesEnCurso() {
        List<IncidenteEntity> source = incidenteRepository.findByFechaFinalizacionIsNull();
        List<IncidenteDTO> target = source.stream().map(incidente -> incidenteEntityConverter.convert(incidente)).toList();
        return target;
    }

    @Override
    public List<IncidenteDTO> findIncidentesFinalizados() {
        List<IncidenteEntity> source = incidenteRepository.findByFechaFinalizacionIsNotNull();
        List<IncidenteDTO> target = source.stream().map(incidente -> incidenteEntityConverter.convert(incidente)).toList();
        return target;
    }
}
