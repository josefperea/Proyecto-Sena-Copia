package com.prueba.prueba_apiN2.controllers.dtos;


import java.time.LocalDateTime;

public class InventarioDTO {
    private Long id;
    private String nombre;
    private LocalDateTime fecha_registro;

    public InventarioDTO(Long id, String nombre, LocalDateTime fecha_registro) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_registro = fecha_registro;
    }

    public InventarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }
}
