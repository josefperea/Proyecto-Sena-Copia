package com.prueba.prueba_apiN2.services;

import com.prueba.prueba_apiN2.services.models.InventarioModel;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public InventarioModel saveInventario(InventarioModel inventarioModel) {
        return inventarioRepository.saveInventario(inventarioModel);
    }

    public InventarioModel updateInventario(Long inventarioId, String nombre, LocalDateTime fecha_registro) {
        Optional<InventarioModel> optionalInventarioModel = inventarioRepository.getInventario(inventarioId);

        if (optionalInventarioModel.isEmpty()) {
            throw new NotFoundException("Task not found");
        }

        return inventarioRepository.updateInventario(inventarioId, InventarioModel.fromData(
                inventarioId,
                nombre,
                fecha_registro
        ));
    }

    public InventarioModel searchInventario(Long inventarioId) {

        Optional<InventarioModel> optionalInventarioModel = inventarioRepository.getInventario(inventarioId);

        if (optionalInventarioModel.isEmpty()) {
            throw new NotFoundException("Task not found");
        }

        return optionalInventarioModel.get();
    }

    public void deleteInventario(Long inventarioId) {
        inventarioRepository.deleteInventario(inventarioId);
    }

    public List<InventarioModel> getInventarios() {
        List<InventarioModel> optionalInventarioModel = inventarioRepository.getAllInventarios();

        if (optionalInventarioModel.isEmpty()) {
            throw new NotFoundException("Clients not found");
        }

        return optionalInventarioModel;
    }
}
