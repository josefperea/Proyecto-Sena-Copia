package com.prueba.prueba_apiN2.controllers;

import com.prueba.prueba_apiN2.config.ProductoJoinInventarioMapper;
import com.prueba.prueba_apiN2.controllers.dtos.ProductoJoinInventarioDTO;
import com.prueba.prueba_apiN2.services.ProductoJoinInventarioService;
import com.prueba.prueba_apiN2.services.models.InventarioModel;
import com.prueba.prueba_apiN2.services.models.ProductoJoinInventarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productoEnInventario")
public class ProductoJoinInventarioController {

    @Autowired
    private ProductoJoinInventarioService productoJoinInventarioService;

    @Autowired
    public ProductoJoinInventarioController(ProductoJoinInventarioService productoJoinInventarioService) {
        this.productoJoinInventarioService = productoJoinInventarioService;
    }

    @PostMapping
    public ResponseEntity<ProductoJoinInventarioDTO> saveProductoJoinInventario(@RequestBody ProductoJoinInventarioDTO request) {
        ProductoJoinInventarioDTO response = ProductoJoinInventarioMapper.toDTO(
                productoJoinInventarioService.saveProductoJoinInventario(
                        ProductoJoinInventarioModel.create(
                                request.getInventario_id(),
                                request.getProducto_id(),
                                request.getCantidad())
                )
        );

        return ResponseEntity.ok(response);
    }
}
