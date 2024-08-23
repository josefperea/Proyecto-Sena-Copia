package com.prueba.prueba_apiN2.services.models;

import java.sql.Date;

public class ProductoModel {
    private Long id;
    private String cod_barras;
    private String nombre;
    private String unidad_medida;
    private float precio;
    private Date fecha_vencimiento;

    public ProductoModel(Long id, String cod_barras, String nombre, String unidad_medida, float precio, Date fecha_vencimiento) {
        this.id = id;
        this.cod_barras = cod_barras;
        this.nombre = nombre;
        this.unidad_medida = unidad_medida;
        this.precio = precio;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public ProductoModel(String cod_barras, String nombre, String unidad_medida, float precio, Date fecha_vencimiento) {
        this.cod_barras = cod_barras;
        this.nombre = nombre;
        this.unidad_medida = unidad_medida;
        this.precio = precio;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Long getId() {
        return id;
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

    public static ProductoModel create(String cod_barras, String nombre, String unidad_medida, float precio, Date fecha_vencimiento) {
        return new ProductoModel(cod_barras, nombre, unidad_medida, precio, fecha_vencimiento);
    }

    public static ProductoModel fromData(Long id, String cod_barras, String nombre, String unidad_medida, float precio, Date fecha_vencimiento) {
        return new ProductoModel(id, cod_barras, nombre, unidad_medida, precio, fecha_vencimiento);
    }
}
