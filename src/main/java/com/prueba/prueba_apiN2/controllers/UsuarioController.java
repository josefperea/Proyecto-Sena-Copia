package com.prueba.prueba_apiN2.controllers;

import com.prueba.prueba_apiN2.controllers.dtos.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.*;

import com.prueba.prueba_apiN2.services.UsuarioService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
@SessionAttributes("username")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioController {

    @Autowired
    UsuarioService service;

//    @RequestMapping(value="/login", method= RequestMethod.GET)
//    public String viewLoginPage(ModelMap map) {
//        return "login";
//    }

    @PostMapping(value="/login")
    public Map<String, Object> showWelcomePage(Model model, @RequestBody UsuarioDTO usuario){

        boolean isValidUser = service.validateUser(usuario.getUsuario(), usuario.getClave());
        Map<String, Object> response = new HashMap<>();

        if (!isValidUser) {
            model.addAttribute("errorMessage", "Acceso Denegado, Credenciales Invalidas");
            response.put("message", model.getAttribute("errorMessage").toString());
            response.put("status", "error");

            return response;
        } else {
            // model.addAttribute("username", usuario.getUsuario());
            response.put("usuario", usuario.getUsuario());
            response.put("clave", usuario.getClave());
            response.put("message", "Bienvenido " + usuario.getUsuario());
            response.put("status", "ok");
            return response;

        }

//        model.put("name", name);
//        model.put("password", password);
    }

    @GetMapping(value="/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "fin";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        String username = (String) model.getAttribute("username");
        return "dashboard"+username;
    }

}