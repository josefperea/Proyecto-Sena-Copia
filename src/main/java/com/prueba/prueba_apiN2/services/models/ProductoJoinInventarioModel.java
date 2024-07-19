package com.prueba.prueba_apiN2.services.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class ProductoJoinInventarioModel {
    private Long id;
    private Long inventario_id ;
    private Long producto_id ;
    private int cantidad;


    public ProductoJoinInventarioModel(Long id, Long inventario_id, Long producto_id, int cantidad) {
        this.id = id;
        this.inventario_id = inventario_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }

    public ProductoJoinInventarioModel(Long inventario_id, Long producto_id, int cantidad) {
        this.inventario_id = inventario_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public Long getInventario_id() {
        return inventario_id;
    }

    public void setInventario_id(Long inventario_id) {
        this.inventario_id = inventario_id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static ProductoJoinInventarioModel create(Long inventario_id, Long producto_id, int cantidad) {
        return new ProductoJoinInventarioModel(inventario_id, producto_id, cantidad);
    }

    public static ProductoJoinInventarioModel fromData(Long id, Long inventario_id, Long producto_id, int cantidad) {
        return new ProductoJoinInventarioModel(id, inventario_id, producto_id, cantidad);
    }
}
