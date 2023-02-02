package com.allavona.tfg.api.converter;

import com.allavona.tfg.api.vo.TipoRecurso;
import com.allavona.tfg.api.vo.Usuario;
import com.allavona.tfg.business.bbdd.entity.TipoRecursoEntity;
import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import org.springframework.beans.BeanUtils;

public class UsuarioDtoConverter {
    public Usuario convert(final UsuarioEntity source ) {
        final Usuario target = new Usuario();
        BeanUtils.copyProperties(source, target);
        return target;
    }

}
