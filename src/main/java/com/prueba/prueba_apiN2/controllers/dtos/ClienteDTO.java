package com.prueba.prueba_apiN2.controllers.dtos;


public class ClienteDTO {
    private Long id;
    private String documento;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;

    public ClienteDTO(Long id, String documento, String nombre, String telefono, String direccion, String correo) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public ClienteDTO() { }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }
}
