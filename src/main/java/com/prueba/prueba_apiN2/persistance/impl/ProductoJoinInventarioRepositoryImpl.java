package com.prueba.prueba_apiN2.persistance.impl;

import com.prueba.prueba_apiN2.config.ProductoJoinInventarioMapper;
import com.prueba.prueba_apiN2.persistance.entities.ProductoJoinInventarioEntity;
import com.prueba.prueba_apiN2.persistance.impl.jpa.JPAProductoJoinInventarioRepository;
import com.prueba.prueba_apiN2.services.models.ProductoJoinInventarioModel;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.repositories.ProductoJoinInventarioRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductoJoinInventarioRepositoryImpl implements ProductoJoinInventarioRepository {

    private JPAProductoJoinInventarioRepository jpaProductoJoinInventarioRepository;

    public ProductoJoinInventarioRepositoryImpl(JPAProductoJoinInventarioRepository jpaProductoJoinInventarioRepository) {
        this.jpaProductoJoinInventarioRepository = jpaProductoJoinInventarioRepository;
    }

    @Override
    public ProductoJoinInventarioModel saveProductoJoinInventario(ProductoJoinInventarioModel productoJoinInventarioModel) {
        ProductoJoinInventarioEntity productoJoinInventarioEntity = ProductoJoinInventarioMapper.toEntity(productoJoinInventarioModel);
        productoJoinInventarioEntity = jpaProductoJoinInventarioRepository.save(productoJoinInventarioEntity);
        return ProductoJoinInventarioMapper.toModel(productoJoinInventarioEntity);
    }

}