package com.prueba.prueba_apiN2.services;

import com.prueba.prueba_apiN2.services.models.UsuarioModel;
import com.prueba.prueba_apiN2.services.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public boolean validateUser(String usuario, String clave) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByUsuario(usuario, clave);

        return optionalUsuarioModel.isPresent();
    }
}
