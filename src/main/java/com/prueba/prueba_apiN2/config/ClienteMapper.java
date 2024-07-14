package com.prueba.prueba_apiN2.config;

import com.prueba.prueba_apiN2.controllers.dtos.ClienteDTO;
import com.prueba.prueba_apiN2.persistance.entities.ClienteEntity;
import com.prueba.prueba_apiN2.services.models.ClienteModel;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public static List<ClienteModel> toModelList(List<ClienteEntity> entities) {
        List<ClienteModel> models = new ArrayList<>();
        if (entities != null) {
            for (ClienteEntity entity : entities) {
                models.add(toModel(entity));
            }
        }
        return models;
    }

    public static List<ClienteDTO> toDTOList(List<ClienteModel> models) {
        List<ClienteDTO> dtos = new ArrayList<>();
        if (models != null) {
            for (ClienteModel model : models) {
                ClienteDTO dto = toDTO(model);
                if (dto != null) {
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }

    public static ClienteDTO toDTO(ClienteModel model) {
        return new ClienteDTO(
                model.getId(),
                model.getDocumento(),
                model.getNombre(),
                model.getTelefono(),
                model.getDireccion(),
                model.getCorreo()
        );
    }

    public static ClienteModel toModel(ClienteEntity entity) {
        return new ClienteModel(
                entity.getId(),
                entity.getDocumento(),
                entity.getNombre(),
                entity.getTelefono(),
                entity.getDireccion(),
                entity.getCorreo()
        );
    }

    public static ClienteEntity toEntity(ClienteModel model) {
        return new ClienteEntity(
                model.getId(),
                model.getDocumento(),
                model.getNombre(),
                model.getTelefono(),
                model.getDireccion(),
                model.getCorreo()
        );
    }
}
