package com.prueba.prueba_apiN2.persistance.impl.jpa;

import com.prueba.prueba_apiN2.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProductoRepository extends JpaRepository<ProductoEntity, Long> {
}