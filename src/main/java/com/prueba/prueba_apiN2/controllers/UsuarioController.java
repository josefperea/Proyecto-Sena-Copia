package com.prueba.prueba_apiN2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.*;

import com.prueba.prueba_apiN2.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
@SessionAttributes("username")
public class UsuarioController {

    @Autowired
    UsuarioService service;

//    @RequestMapping(value="/login", method= RequestMethod.GET)
//    public String viewLoginPage(ModelMap map) {
//        return "login";
//    }

    @PostMapping(value="/login")
    public String showWelcomePage(Model model, @RequestParam String username, @RequestParam String password){

        boolean isValidUser = service.validateUser(username, password);

        if (!isValidUser) {
            model.addAttribute("errorMessage", "Access Denied , Invalid Credentials");
            return model.getAttribute("errorMessage").toString();
        } else {
            model.addAttribute("username", username);
            return "welcome";
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