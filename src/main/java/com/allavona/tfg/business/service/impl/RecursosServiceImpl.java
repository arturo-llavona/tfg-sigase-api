package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.bbdd.repository.RecursoRepository;
import com.allavona.tfg.business.converter.RecursoEntityConverter;
import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.service.RecursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursosServiceImpl implements RecursosService {
    @Autowired
    private RecursoRepository repository;

    private RecursoEntityConverter converter = new RecursoEntityConverter();

    @Override
    public List<RecursoDTO> findAll() {
        List<RecursoEntity> source =  repository.findAll();
        List<RecursoDTO> recursos = source.stream().map(recurso -> converter.convert(recurso)).toList();
        return recursos;
    }
}
