package com.prueba.prueba_apiN2.services.models;

public class ClienteModel {
    private Long id;
    private String documento;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;

    public ClienteModel(Long id, String documento, String nombre, String telefono, String direccion, String correo) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public ClienteModel(String documento, String nombre, String telefono, String direccion, String correo) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static ClienteModel create(String documento, String nombre, String telefono, String direccion, String correo) {
        return new ClienteModel(documento, nombre, telefono, direccion, correo);
    }

    public static ClienteModel fromData(Long id, String documento, String nombre, String telefono, String direccion, String correo) {
        return new ClienteModel(id, documento, nombre, telefono, direccion, correo);
    }
}
