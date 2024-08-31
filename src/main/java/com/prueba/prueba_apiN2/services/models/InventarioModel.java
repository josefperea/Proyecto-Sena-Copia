package com.prueba.prueba_apiN2.services.models;

import java.time.LocalDateTime;

public class InventarioModel {
    private Long id;
    private LocalDateTime fecha_registro;
    private String nota;
    private Long productoId; // ID del producto
    private String nombreProducto; // Nombre del producto
    private int cantidad;

    public InventarioModel(Long id, LocalDateTime fecha_registro, String nota,  Long productoId, String nombreProducto, int cantidad) {
        this.id = id;
        this.fecha_registro = fecha_registro;
        this.nota = nota;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public InventarioModel(LocalDateTime fecha_registro, String nota, Long productoId, String nombreProducto, int cantidad) {
        this.fecha_registro = fecha_registro;
        this.nota = nota;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }


    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }


    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static InventarioModel create(LocalDateTime fecha_registro,
                                         String nota, Long productoId, String nombreProducto, int cantidad) {
        return new InventarioModel(fecha_registro, nota, productoId, nombreProducto, cantidad);
    }

    public static InventarioModel fromData(Long id, LocalDateTime fecha_registro,
                                           String nota, Long productoId, String nombreProducto, int cantidad) {
        return new InventarioModel(id, fecha_registro, nota, productoId, nombreProducto, cantidad);
    }
}
