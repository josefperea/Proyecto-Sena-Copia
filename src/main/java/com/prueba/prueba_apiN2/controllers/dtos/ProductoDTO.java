package com.prueba.prueba_apiN2.controllers.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class ProductoDTO {

    private Long id;
    private String cod_barras;
    private String nombre;
    private String unidad_medida;
    private float precio;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_vencimiento;

    public ProductoDTO(Long id, String cod_barras, String nombre, String unidad_medida, float precio, Date fecha_vencimiento) {
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

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }
}
