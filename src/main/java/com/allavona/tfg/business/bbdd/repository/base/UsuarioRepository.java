package com.allavona.tfg.business.bbdd.repository.base;

import com.allavona.tfg.business.bbdd.entity.base.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    @Query(value = "SELECT * FROM usuario WHERE username = ?1 AND password = ?2 AND habilitado = TRUE", nativeQuery = true)
    UsuarioEntity autenticar(String username, String password);
}
