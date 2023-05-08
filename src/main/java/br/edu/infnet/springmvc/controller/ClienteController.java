package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.model.negocio.Cliente;
import br.edu.infnet.springmvc.model.negocio.Usuario;
import br.edu.infnet.springmvc.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes("user")
@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/cliente")
    public String mostrarCliente(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("lista", clienteService.obterLista(usuario));
        model.addAttribute("cliente", new Cliente());

        return "cliente/cadastro&lista";
    }

    @PostMapping(value = "/cliente/salvar")
    public String salvar(Cliente cliente, @SessionAttribute("user") Usuario usuario) {

        cliente.setUsuario(usuario);
        clienteService.salvar(cliente);
        return "redirect:/cliente";
    }

    @GetMapping(value = "/cliente/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id) {

        clienteService.excluir(id);
        return "redirect:/cliente";
    }


    @RequestMapping("/cliente/alterar")
    public ModelAndView alterar(Model model, @RequestParam int id) {

        ModelAndView mav = new ModelAndView("/cliente/cadastro&lista");
        Cliente cliente = clienteService.consultarPorId(id);

        mav.addObject(cliente);
        return mav;
    }
}
