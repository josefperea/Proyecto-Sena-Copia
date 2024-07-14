package com.prueba.prueba_apiN2.controllers;

import com.prueba.prueba_apiN2.config.ProductoMapper;
import com.prueba.prueba_apiN2.controllers.dtos.ProductoDTO;
import com.prueba.prueba_apiN2.services.ProductoService;
import com.prueba.prueba_apiN2.services.models.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> saveProducto(@RequestBody ProductoDTO request) {
        ProductoDTO response = ProductoMapper.toDTO(
                productoService.saveProducto(
                        ProductoModel.create(
                                request.getCod_barras(),
                                request.getNombre(),
                                request.getUnidad_medida(),
                                request.getPrecio(),
                                request.getFecha_vencimiento()
                        )
                )
        );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long productoId, @RequestBody ProductoDTO request) {
        ProductoDTO response = ProductoMapper.toDTO(
                productoService.updateProducto(
                        productoId, request.getCod_barras(), request.getNombre(), request.getUnidad_medida(),
                        request.getPrecio(), request.getFecha_vencimiento()
                )
        );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{productoId}")
    public ResponseEntity<ProductoDTO> searchProducto(
            @PathVariable Long productoId
    ) {
        ProductoDTO response = ProductoMapper.toDTO(
                productoService.searchProducto(productoId)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getProductos")
    public ResponseEntity<List<ProductoDTO>> getProductos() {
        List<ProductoDTO> response = ProductoMapper.toDTOList(productoService.getProductos());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long productoId) {
        productoService.deleteProducto(productoId);
        return ResponseEntity.ok().build();
    }
}
