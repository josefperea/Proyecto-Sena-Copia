package com.prueba.prueba_apiN2.config;

import com.prueba.prueba_apiN2.controllers.dtos.InventarioDTO;
import com.prueba.prueba_apiN2.persistance.entities.InventarioEntity;
import com.prueba.prueba_apiN2.services.models.InventarioModel;

import java.util.ArrayList;
import java.util.List;

public class InventarioMapper {

    public static List<InventarioModel> toModelList(List<InventarioEntity> entities) {
        List<InventarioModel> models = new ArrayList<>();
        if (entities != null) {
            for (InventarioEntity entity : entities) {
                models.add(toModel(entity));
            }
        }
        return models;
    }

    public static List<InventarioDTO> toDTOList(List<InventarioModel> models) {
        List<InventarioDTO> dtos = new ArrayList<>();
        if (models != null) {
            for (InventarioModel model : models) {
                InventarioDTO dto = toDTO(model);
                if (dto != null) {
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }

    public static InventarioDTO toDTO(InventarioModel model) {
        return new InventarioDTO(
                model.getId(),
                model.getNombre(),
                model.getFecha_registro()
        );
    }

    public static InventarioModel toModel(InventarioEntity entity) {
        return new InventarioModel(
                entity.getId(),
                entity.getNombre(),
                entity.getFecha_registro()
        );
    }

    public static InventarioEntity toEntity(InventarioModel model) {
        return new InventarioEntity(
                model.getId(),
                model.getNombre(),
                model.getFecha_registro()
        );
    }
}