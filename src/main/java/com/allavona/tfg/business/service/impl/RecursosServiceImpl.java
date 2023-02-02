package com.allavona.tfg.business.service.impl;

import com.allavona.tfg.api.converter.RecursoDtoConverter;
import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.bbdd.repository.RecursoRepository;
import com.allavona.tfg.business.converter.RecursoEntityConverter;
import com.allavona.tfg.business.dto.RecursoDTO;
import com.allavona.tfg.business.service.RecursosService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class RecursosServiceImpl implements RecursosService {
    @Autowired
    private RecursoRepository recursoRepository;

    private RecursoEntityConverter recursoEntityConverter = new RecursoEntityConverter();

    @Override
    public List<RecursoDTO> findAll() {
        List<RecursoEntity> source =  recursoRepository.findAll();
        List<RecursoDTO> recursos = source.stream().map(recurso -> recursoEntityConverter.convert(recurso)).toList();
        return recursos;
    }
}
