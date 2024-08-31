package com.prueba.prueba_apiN2.controllers.dtos;

public class UsuarioDTO {
    private Long id;
    private String usuario;
    private String clave;

    public UsuarioDTO(Long id, String usuario, String clave) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
    }

    public UsuarioDTO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public UsuarioDTO() { }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
}
