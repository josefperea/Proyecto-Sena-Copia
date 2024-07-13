package com.prueba.prueba_apiN2.controllers.dtos;


public class ProductoDTO {

    private Long id;
    private String cod_barras;
    private String nombre;
    private String unidad_medida;
    private float precio;
    private String fecha_vencimiento;

    public ProductoDTO(Long id, String cod_barras, String nombre, String unidad_medida, float precio, String fecha_vencimiento) {
        this.id = id;
        this.cod_barras = cod_barras;
        this.nombre = nombre;
        this.unidad_medida = unidad_medida;
        this.precio = precio;
        this.fecha_vencimiento = fecha_vencimiento;
    }


    public ProductoDTO() { }


    public Long getId() {
        return id;
    }

    public String getCod_barras() {
        return cod_barras;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public float getPrecio() {
        return precio;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }
}
