package com.prueba.prueba_apiN2.services.repositories;

import com.prueba.prueba_apiN2.services.models.ProductoModel;

import java.util.List;
import java.util.Optional;


public interface ProductoRepository {
    ProductoModel saveProducto(ProductoModel productoModel);
    ProductoModel updateProducto(Long productoId, ProductoModel productoModel);

    Optional<ProductoModel> getProducto(Long id);

    ProductoModel getProductoModel(Long id);

    void deleteProducto(Long productoId);

    List<ProductoModel> getAllProductos();

}