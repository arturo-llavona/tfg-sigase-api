package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.ClasificacionIncidenteEntity;
import com.allavona.tfg.business.bbdd.repository.ClasificacionIncidenteRepository;
import com.allavona.tfg.business.converter.ClasificacionIncidenteEntityConverter;
import com.allavona.tfg.business.dto.ClasificacionIncidenteDTO;
import com.allavona.tfg.business.service.IncidentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentesServiceImpl implements IncidentesService {
    @Autowired
    private ClasificacionIncidenteRepository repository;

    private ClasificacionIncidenteEntityConverter converter = new ClasificacionIncidenteEntityConverter();

    @Override
    public List<ClasificacionIncidenteDTO> findByCodigo(final String codigo) {
        List<ClasificacionIncidenteEntity> source =  repository.findByCodigoStartingWith(codigo);
        List<ClasificacionIncidenteDTO> recursos = source.stream().map(recurso -> converter.convert(recurso)).toList();
        return recursos;
    }
}
