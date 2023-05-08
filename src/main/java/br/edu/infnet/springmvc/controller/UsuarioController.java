package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.model.negocio.Usuario;
import br.edu.infnet.springmvc.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/usuario/login")
    public String login(ModelMap model, @RequestParam String email, @RequestParam String senha) {

        Usuario usuario = usuarioService.autenticacao(email, senha);
        if (usuario == null) {
            model.addAttribute("erro", "Verifique suas credenciais e tente novamente.");
            return "login";
        } else {
            model.put("user", usuario);
            return "redirect:/cliente";
        }
    }

    @GetMapping(value = "/usuario")
    public String mostrarUsuario(Model model) {

        model.addAttribute("voltar", "/");

        return "usuario/cadastro";
    }


    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {

        usuarioService.incluir(usuario);

        return "usuario/confirmacao";
    }
}
