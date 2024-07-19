package com.prueba.prueba_apiN2.controllers.dtos;

public class ProductoJoinInventarioDTO {
    private Long id;
    private Long inventario_id ;
    private Long producto_id ;
    private int cantidad;


    public ProductoJoinInventarioDTO(Long id, Long inventario_id, Long producto_id, int cantidad) {
        this.id = id;
        this.inventario_id = inventario_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }

    public ProductoJoinInventarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public Long getInventario_id() {
        return inventario_id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }
}
