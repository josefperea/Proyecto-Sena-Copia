package com.prueba.prueba_apiN2.persistance.impl.jpa;

import com.prueba.prueba_apiN2.persistance.entities.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAInventarioRepository extends JpaRepository<InventarioEntity, Long> {
}