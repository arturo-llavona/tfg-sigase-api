package com.allavona.tfg.business.bbdd.repository;

import com.allavona.tfg.business.bbdd.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    @Query(value = "SELECT * FROM usuario WHERE username = ?1 AND password = ?2 AND habilitado = TRUE", nativeQuery = true)
    UsuarioEntity autenticar(String username, String password);
    UsuarioEntity findByUsername(String username);
}
