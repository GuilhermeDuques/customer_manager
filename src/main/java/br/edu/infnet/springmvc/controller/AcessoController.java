package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcessoController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String init() {
        return "login";
    }
}
