package com.prueba.prueba_apiN2.config;

import com.prueba.prueba_apiN2.controllers.dtos.UsuarioDTO;
import com.prueba.prueba_apiN2.persistance.entities.UsuarioEntity;
import com.prueba.prueba_apiN2.services.models.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static List<UsuarioModel> toModelList(List<UsuarioEntity> entities) {
        List<UsuarioModel> models = new ArrayList<>();
        if (entities != null) {
            for (UsuarioEntity entity : entities) {
                models.add(toModel(entity));
            }
        }
        return models;
    }

    public static List<UsuarioDTO> toDTOList(List<UsuarioModel> models) {
        List<UsuarioDTO> dtos = new ArrayList<>();
        if (models != null) {
            for (UsuarioModel model : models) {
                UsuarioDTO dto = toDTO(model);
                if (dto != null) {
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }

    public static UsuarioDTO toDTO(UsuarioModel model) {
        return new UsuarioDTO(
                model.getId(),
                model.getUsuario(),
                model.getClave()
        );
    }

    public static UsuarioModel toModel(UsuarioEntity entity) {
        return new UsuarioModel(
                entity.getId(),
                entity.getUsuario(),
                entity.getClave()
        );
    }

    public static UsuarioEntity toEntity(UsuarioModel model) {
        return new UsuarioEntity(
                model.getId(),
                model.getUsuario(),
                model.getClave()
        );
    }
}
