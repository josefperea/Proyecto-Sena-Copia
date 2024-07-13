package com.prueba.prueba_apiN2.config.mappers;

import com.prueba.prueba_apiN2.controllers.dtos.ProductoDTO;
import com.prueba.prueba_apiN2.persistance.entities.ProductoEntity;
import com.prueba.prueba_apiN2.services.models.ProductoModel;

import java.util.ArrayList;
import java.util.List;

public class ProductoMapper {

    public static List<ProductoModel> toModelList(List<ProductoEntity> entities) {
        List<ProductoModel> models = new ArrayList<>();
        if (entities != null) {
            for (ProductoEntity entity : entities) {
                models.add(toModel(entity));
            }
        }
        return models;
    }

    public static List<ProductoDTO> toDTOList(List<ProductoModel> models) {
        List<ProductoDTO> dtos = new ArrayList<>();
        if (models != null) {
            for (ProductoModel model : models) {
                ProductoDTO dto = toDTO(model);
                if (dto != null) {
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }

    public static ProductoDTO toDTO(ProductoModel model) {
        return new ProductoDTO(
                model.getId(),
                model.getCod_barras(),
                model.getNombre(),
                model.getUnidad_medida(),
                model.getPrecio(),
                model.getFecha_vencimiento()
        );
    }

    public static ProductoModel toModel(ProductoEntity entity) {
        return new ProductoModel(
                entity.getId(),
                entity.getCod_barras(),
                entity.getNombre(),
                entity.getUnidad_medida(),
                entity.getPrecio(),
                entity.getFecha_vencimiento()
        );
    }

    public static ProductoEntity toEntity(ProductoModel model) {
        return new ProductoEntity(
                model.getId(),
                model.getCod_barras(),
                model.getNombre(),
                model.getUnidad_medida(),
                model.getPrecio(),
                model.getFecha_vencimiento()
        );
    }
}
