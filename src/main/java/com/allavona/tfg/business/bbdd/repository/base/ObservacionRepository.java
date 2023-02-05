package com.allavona.tfg.business.bbdd.repository.base;

import com.allavona.tfg.business.bbdd.entity.base.ObservacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservacionRepository extends JpaRepository<ObservacionEntity, Integer> {
    List<ObservacionEntity> findAllByIdIncidente(Integer idIncidente);

}
