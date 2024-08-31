package com.prueba.prueba_apiN2.persistance.impl.jpa;

import com.prueba.prueba_apiN2.persistance.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query("SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.clave = :clave")
    Optional<UsuarioEntity> findByUsuarioAndClave(@Param("usuario") String usuario, @Param("clave") String clave);
}