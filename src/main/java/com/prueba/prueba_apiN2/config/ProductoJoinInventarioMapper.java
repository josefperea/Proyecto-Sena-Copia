package com.prueba.prueba_apiN2.config;

import com.prueba.prueba_apiN2.controllers.dtos.ProductoJoinInventarioDTO;
import com.prueba.prueba_apiN2.persistance.entities.ProductoJoinInventarioEntity;
import com.prueba.prueba_apiN2.services.models.ProductoJoinInventarioModel;

import java.util.ArrayList;
import java.util.List;

public class ProductoJoinInventarioMapper {

    public static List<ProductoJoinInventarioModel> toModelList(List<ProductoJoinInventarioEntity> entities) {
        List<ProductoJoinInventarioModel> models = new ArrayList<>();
        if (entities != null) {
            for (ProductoJoinInventarioEntity entity : entities) {
                models.add(toModel(entity));
            }
        }
        return models;
    }

    public static List<ProductoJoinInventarioDTO> toDTOList(List<ProductoJoinInventarioModel> models) {
        List<ProductoJoinInventarioDTO> dtos = new ArrayList<>();
        if (models != null) {
            for (ProductoJoinInventarioModel model : models) {
                ProductoJoinInventarioDTO dto = toDTO(model);
                if (dto != null) {
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }

    public static ProductoJoinInventarioDTO toDTO(ProductoJoinInventarioModel model) {
        return new ProductoJoinInventarioDTO(
                model.getId(),
                model.getInventario_id(),
                model.getProducto_id(),
                model.getCantidad()
        );
    }

    public static ProductoJoinInventarioModel toModel(ProductoJoinInventarioEntity entity) {
        return new ProductoJoinInventarioModel(
                entity.getId(),
                entity.getInventario_id(),
                entity.getProducto_id(),
                entity.getCantidad()
        );
    }

    public static ProductoJoinInventarioEntity toEntity(ProductoJoinInventarioModel model) {
        return new ProductoJoinInventarioEntity(
                model.getId(),
                model.getInventario_id(),
                model.getProducto_id(),
                model.getCantidad()
        );
    }
}
