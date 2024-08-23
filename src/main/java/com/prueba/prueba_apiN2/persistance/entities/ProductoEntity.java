package com.prueba.prueba_apiN2.persistance.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "productos")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cod_barras")
    private String cod_barras;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "unidad_medida")
    private String unidad_medida;

    @Column(name = "precio")
    private float precio;

    @Column(name = "fecha_vencimiento")
    private Date fecha_vencimiento;

    public ProductoEntity(Long id, String cod_barras, String nombre, String unidad_medida, float precio, Date fecha_vencimiento) {
        this.id = id;
        this.cod_barras = cod_barras;
        this.nombre = nombre;
        this.unidad_medida = unidad_medida;
        this.precio = precio;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public ProductoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(String cod_barras) {
        this.cod_barras = cod_barras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
}