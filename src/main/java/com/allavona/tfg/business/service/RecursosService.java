package com.allavona.tfg.business.service;

import com.allavona.tfg.api.vo.Recurso;
import com.allavona.tfg.business.bbdd.entity.RecursoEntity;
import com.allavona.tfg.business.dto.RecursoDTO;

import java.util.List;

public interface RecursosService {
    public List<RecursoDTO> findAll();
}
