package com.prueba.prueba_apiN2.persistance.impl.jpa;

import com.prueba.prueba_apiN2.persistance.entities.ProductoJoinInventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProductoJoinInventarioRepository extends JpaRepository<ProductoJoinInventarioEntity, Long> {
}