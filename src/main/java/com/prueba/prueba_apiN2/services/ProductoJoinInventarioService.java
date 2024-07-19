package com.prueba.prueba_apiN2.services;

import com.prueba.prueba_apiN2.services.models.ProductoJoinInventarioModel;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.repositories.ProductoJoinInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoJoinInventarioService {

    @Autowired
    private ProductoJoinInventarioRepository productoJoinInventarioRepository;

    public ProductoJoinInventarioModel saveProductoJoinInventario(ProductoJoinInventarioModel productoJoinInventarioModel) {
        return productoJoinInventarioRepository.saveProductoJoinInventario(productoJoinInventarioModel);
    }
}
