package com.prueba.prueba_apiN2.services;

import com.prueba.prueba_apiN2.services.models.ProductoModel;
import com.prueba.prueba_apiN2.services.models.NotFoundException;
import com.prueba.prueba_apiN2.services.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    private final String directorioImagenes = "uploads/productos/";

    public ProductoModel saveProducto(ProductoModel productoModel) {
        return productoRepository.saveProducto(productoModel);
    }

    public ProductoModel updateProducto(Long productoId, String cod_barras, String nombre, String unidad_medida, float precio, Date fecha_vencimiento, String imagen_url) {
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
                fecha_vencimiento,
                imagen_url
        ));
    }

    public ProductoModel searchProducto(Long productoId) {

        Optional<ProductoModel> optionalProductoModel = productoRepository.getProducto(productoId);

        if (optionalProductoModel.isEmpty()) {
            throw new NotFoundException("Product not found");
        }

        return optionalProductoModel.get();
    }

    public void deleteProducto(Long productoId) throws IOException {
        this.quitarImagen(productoId);
        productoRepository.deleteProducto(productoId);
    }

    public List<ProductoModel> getProductos() {
        List<ProductoModel> optionalProductoModel = productoRepository.getAllProductos();

        if (optionalProductoModel.isEmpty()) {
            throw new NotFoundException("No se encontraron productos");
        }

        return optionalProductoModel;
    }


    public String subirImagen(Long idProducto, MultipartFile archivo) throws IOException {
        // 1. Buscar el producto en la base de datos
        ProductoModel producto = productoRepository.getProductoModel(idProducto);

        // 2. Eliminar la imagen anterior (si existe)
        if ( !producto.getImagen_url().isEmpty() && producto.getImagen_url().contains("/productos/") )  {
            Path rutaImagenAnterior = Paths.get(directorioImagenes + producto.getImagen_url().substring("uploads/productos/".length()));
            Files.deleteIfExists(rutaImagenAnterior);  // Borra la imagen anterior si existe
        }

        // 3. Guardar el archivo en el sistema de archivos
        String nombreArchivo = archivo.getOriginalFilename();
        Path rutaImagen = Paths.get(directorioImagenes + nombreArchivo);
        Files.write(rutaImagen, archivo.getBytes());

        // 4. Guardar la URL de la imagen en el producto
        String urlImagen = "uploads/productos/" + nombreArchivo;  // Ajusta la URL según sea necesario
        producto.setImagen_url(urlImagen);

        // 5. Guardar el producto actualizado en la base de datos
        productoRepository.saveProducto(producto);

        return urlImagen;  // Retornar la URL de la imagen
    }

    public boolean quitarImagen(Long idProducto) throws IOException {
       // 1. Buscar el producto en la base de datos
        ProductoModel producto = productoRepository.getProductoModel(idProducto);

        // 2. Eliminar la imagen anterior (si existe)
        if ( !producto.getImagen_url().isEmpty() && producto.getImagen_url().contains("/productos/") )  {
            Path rutaImagenAnterior = Paths.get(directorioImagenes + producto.getImagen_url().substring("uploads/productos/".length()));
            return Files.deleteIfExists(rutaImagenAnterior);
        }
        return false;
    }

}
