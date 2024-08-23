package com.prueba.prueba_apiN2.persistance.impl;

import com.prueba.prueba_apiN2.config.InventarioMapper;
import com.prueba.prueba_apiN2.persistance.entities.InventarioEntity;
import com.prueba.prueba_apiN2.persistance.impl.jpa.JPAInventarioRepository;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.models.InventarioModel;
import com.prueba.prueba_apiN2.services.repositories.InventarioRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;


@Component
public class InventarioRepositoryImpl implements InventarioRepository {

    private JPAInventarioRepository JPAInventarioRepository;

    public InventarioRepositoryImpl (JPAInventarioRepository JPAInventarioRepository) {
        this.JPAInventarioRepository = JPAInventarioRepository;
    }

    @Override
    public Optional<InventarioModel> getInventario(Long inventarioId) {
        Optional<InventarioEntity> InventarioEntity = JPAInventarioRepository.findById(inventarioId);
        return InventarioEntity.isPresent() ? Optional.of(InventarioMapper.toModel(InventarioEntity.get())) : Optional.empty();
    }

    @Override
    public InventarioModel saveInventario(InventarioModel InventarioModel) {
        InventarioEntity InventarioEntity = InventarioMapper.toEntity(InventarioModel);
        InventarioEntity = JPAInventarioRepository.save(InventarioEntity);
        return InventarioMapper.toModel(InventarioEntity);
    }

    @Override
    public InventarioModel updateInventario(Long taskId, InventarioModel inventarioModel) {
        InventarioEntity existingInventarioEntity = JPAInventarioRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        existingInventarioEntity.setFecha_registro(inventarioModel.getFecha_registro());
        existingInventarioEntity.setNota(inventarioModel.getNota());
        existingInventarioEntity.setCantidad(inventarioModel.getCantidad());

        InventarioEntity savedInventarioEntity = JPAInventarioRepository.save(existingInventarioEntity);

        return InventarioMapper.toModel(savedInventarioEntity);
    }

    @Override
    public void deleteInventario(Long taskId) {
        JPAInventarioRepository.deleteById(taskId);
    }

    @Override
    public List<InventarioModel> getAllInventarios() {
        List<InventarioEntity> inventario = JPAInventarioRepository.findAll();

        return (!inventario.isEmpty()) ? InventarioMapper.toModelList(inventario) : new ArrayList<>();
    }
}