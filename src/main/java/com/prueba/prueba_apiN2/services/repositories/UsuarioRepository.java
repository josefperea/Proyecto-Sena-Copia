package com.prueba.prueba_apiN2.services.repositories;

import com.prueba.prueba_apiN2.services.models.UsuarioModel;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<UsuarioModel> findByUsuario(String usuario, String clave);
}