package com.prueba.prueba_apiN2.services.models;

import java.time.LocalDateTime;

public class InventarioModel {
    private Long id;
    private String nombre;
    private LocalDateTime fecha_registro;

    public InventarioModel(Long id, String nombre, LocalDateTime fecha_registro) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_registro = fecha_registro;
    }

    public InventarioModel(String nombre, LocalDateTime fecha_registro) {
        this.nombre = nombre;
        this.fecha_registro = fecha_registro;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public static InventarioModel create(String nombre, LocalDateTime fecha_registro) {
        return new InventarioModel(nombre, fecha_registro);
    }

    public static InventarioModel fromData(Long id, String nombre, LocalDateTime fecha_registro) {
        return new InventarioModel(id, nombre, fecha_registro);
    }
}
