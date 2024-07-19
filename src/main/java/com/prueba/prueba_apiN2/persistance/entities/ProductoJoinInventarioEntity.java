package com.prueba.prueba_apiN2.persistance.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventario_has_productos")
public class ProductoJoinInventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JoinColumn(name = "inventario_id")
    @Column(name = "inventario_id ")
    private Long inventario_id;

//    @JoinColumn(name = "producto_id")
    @Column(name = "producto_id ")
    private Long producto_id ;

    @Column(name = "cantidad")
    private int cantidad;


    public ProductoJoinInventarioEntity(Long id, Long inventario_id, Long producto_id, int cantidad) {
        this.id = id;
        this.inventario_id = inventario_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }

    public ProductoJoinInventarioEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}