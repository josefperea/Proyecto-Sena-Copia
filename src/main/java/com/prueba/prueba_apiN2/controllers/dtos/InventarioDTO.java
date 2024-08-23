package com.prueba.prueba_apiN2.controllers.dtos;


import com.prueba.prueba_apiN2.persistance.entities.ProductoEntity;

import java.time.LocalDateTime;

public class InventarioDTO {
    private Long id;
    private LocalDateTime fecha_registro;
    private String nota;
    private Long productoId; // ID del producto para el backend
    private String nombreProducto; // Nombre del producto para mostrar en el frontend
    private int cantidad;



    public InventarioDTO(Long id, LocalDateTime fecha_registro, String nota, Long productoId, String nombreProducto, int  cantidad) {
        this.id = id;
        this.fecha_registro = fecha_registro;
        this.nota = nota;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public InventarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public String getNota() {
        return nota;
    }

    public Long getProductoId() {
        return productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
