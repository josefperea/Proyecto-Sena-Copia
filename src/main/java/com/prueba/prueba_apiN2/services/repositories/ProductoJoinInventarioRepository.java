package com.prueba.prueba_apiN2.services.repositories;

import com.prueba.prueba_apiN2.services.models.InventarioModel;
import com.prueba.prueba_apiN2.services.models.ProductoJoinInventarioModel;

import java.util.List;
import java.util.Optional;


public interface ProductoJoinInventarioRepository {
    ProductoJoinInventarioModel saveProductoJoinInventario(ProductoJoinInventarioModel productoJoinInventarioModel);
}