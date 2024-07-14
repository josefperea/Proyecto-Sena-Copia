package com.prueba.prueba_apiN2.persistance.impl;

import com.prueba.prueba_apiN2.config.ProductoMapper;
import com.prueba.prueba_apiN2.persistance.entities.ProductoEntity;
import com.prueba.prueba_apiN2.persistance.impl.jpa.JPAProductoRepository;
import com.prueba.prueba_apiN2.services.models.ProductoModel;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.repositories.ProductoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProductoRepositoryImpl implements ProductoRepository {

    private JPAProductoRepository jpaProductoRepository;

    public ProductoRepositoryImpl(JPAProductoRepository jpaProductoRepository) {
        this.jpaProductoRepository = jpaProductoRepository;
    }

    @Override
    public Optional<ProductoModel> getProducto(Long productoId) {
        Optional<ProductoEntity> productoEntity = jpaProductoRepository.findById(productoId);
    
        return productoEntity.isPresent() ? Optional.of(ProductoMapper.toModel(productoEntity.get())) : Optional.empty();
    }

    @Override
    public ProductoModel saveProducto(ProductoModel productoModel) {
        ProductoEntity productoEntity = ProductoMapper.toEntity(productoModel);
        productoEntity = jpaProductoRepository.save(productoEntity);
        return ProductoMapper.toModel(productoEntity);
    }

    @Override
    public ProductoModel updateProducto(Long taskId, ProductoModel updatedTask) {
        ProductoEntity existingProductoEntity = jpaProductoRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        existingProductoEntity.setCod_barras(updatedTask.getCod_barras());
        existingProductoEntity.setNombre(updatedTask.getNombre());
        existingProductoEntity.setUnidad_medida(updatedTask.getUnidad_medida());
        existingProductoEntity.setPrecio(updatedTask.getPrecio());
        existingProductoEntity.setFecha_vencimiento(updatedTask.getFecha_vencimiento());

        ProductoEntity savedProductoEntity = jpaProductoRepository.save(existingProductoEntity);

        return ProductoMapper.toModel(savedProductoEntity);
    }

    @Override
    public void deleteProducto(Long taskId) {
        jpaProductoRepository.deleteById(taskId);
    }

    @Override
    public List<ProductoModel> getAllProductos() {
        List<ProductoEntity> tasks = jpaProductoRepository.findAll();

        return (!tasks.isEmpty()) ? ProductoMapper.toModelList(tasks) : new ArrayList<>();
    }
}