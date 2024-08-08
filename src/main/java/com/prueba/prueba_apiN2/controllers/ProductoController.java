package com.prueba.prueba_apiN2.controllers;

import com.prueba.prueba_apiN2.config.ProductoMapper;
import com.prueba.prueba_apiN2.controllers.dtos.ProductoDTO;
import com.prueba.prueba_apiN2.services.ProductoService;
import com.prueba.prueba_apiN2.services.models.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> saveProducto(@RequestBody ProductoDTO request) {
        try {
            // Intentar guardar el producto
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

            // Si se guarda correctamente, retorna un mensaje de éxito
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante el proceso de guardado
            // Retorna un mensaje de error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al guardar el producto: " + e.getMessage());
        }
    }

    // Manejo de excepciones específicas, si es necesario
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error inesperado: " + e.getMessage());
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
    public ResponseEntity<?> getProductos() {
        try {
            List<ProductoDTO> response = ProductoMapper.toDTOList(productoService.getProductos());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante el proceso de guardado
            // Retorna un mensaje de error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long productoId) {

        try {
            productoService.deleteProducto(productoId);

            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante el proceso de guardado
            // Retorna un mensaje de error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }
}
