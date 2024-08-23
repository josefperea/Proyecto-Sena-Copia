package com.prueba.prueba_apiN2.persistance.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventario")
public class InventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha_registro;

    @Column(name = "nota")
    private String nota;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private ProductoEntity producto; // Relación con ProductoEntity

    @Column(name = "cantidad")
    private int cantidad;

    public InventarioEntity(Long id, LocalDateTime fecha_registro, String nota, ProductoEntity producto, int cantidad) {
        this.id = id;
        this.fecha_registro = fecha_registro;
        this.nota = nota;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public InventarioEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}