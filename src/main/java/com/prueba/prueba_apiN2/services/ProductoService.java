package com.prueba.prueba_apiN2.services;

import com.prueba.prueba_apiN2.services.models.ClienteModel;
import com.prueba.prueba_apiN2.services.models.ProductoModel;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoModel saveProducto(ProductoModel productoModel) {
        return productoRepository.saveProducto(productoModel);
    }

    public ProductoModel updateProducto(Long productoId, String cod_barras, String nombre, String unidad_medida, float precio, Date fecha_vencimiento) {
        Optional<ProductoModel> optionalProductoModel = productoRepository.getProducto(productoId);

        if (optionalProductoModel.isEmpty()) {
            throw new NotFoundException("Product not found");
        }

        return productoRepository.updateProducto(productoId, ProductoModel.fromData(
                productoId,
                cod_barras,
                nombre,
                unidad_medida,
                precio,
                fecha_vencimiento
        ));
    }

    public ProductoModel searchProducto(Long productoId) {

        Optional<ProductoModel> optionalProductoModel = productoRepository.getProducto(productoId);

        if (optionalProductoModel.isEmpty()) {
            throw new NotFoundException("Product not found");
        }

        return optionalProductoModel.get();
    }

    public void deleteProducto(Long productoId) {
        productoRepository.deleteProducto(productoId);
    }

    public List<ProductoModel> getProductos() {
        List<ProductoModel> optionalProductoModel = productoRepository.getAllProductos();

        if (optionalProductoModel.isEmpty()) {
            throw new NotFoundException("No se encontraron productos");
        }

        return optionalProductoModel;
    }

}
