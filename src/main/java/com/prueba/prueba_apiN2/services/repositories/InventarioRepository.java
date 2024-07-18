package com.prueba.prueba_apiN2.services.repositories;

import com.prueba.prueba_apiN2.services.models.InventarioModel;
import java.util.List;
import java.util.Optional;


public interface InventarioRepository {
    InventarioModel saveInventario(InventarioModel inventarioModel);
    InventarioModel updateInventario(Long inventarioId, InventarioModel inventarioModel);

    Optional<InventarioModel> getInventario(Long id);

    void deleteInventario(Long clienteId);

    List<InventarioModel> getAllInventarios();

}