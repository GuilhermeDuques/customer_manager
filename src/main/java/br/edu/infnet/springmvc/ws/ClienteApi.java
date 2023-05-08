package br.edu.infnet.springmvc.ws;

import br.edu.infnet.springmvc.model.negocio.Cliente;
import br.edu.infnet.springmvc.model.negocio.Usuario;
import br.edu.infnet.springmvc.model.service.ClienteService;
import br.edu.infnet.springmvc.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/clientes")
public class ClienteApi {
    @Autowired
    private ClienteService service;
    @Autowired
    private UsuarioService usuarioService;


    public ClienteApi() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = service.obterLista();

        if (clientes == null || clientes.isEmpty()) {
            return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> get(@PathVariable("id") int id) {
        try {
            Cliente cliente = service.consultarPorId(id);

            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

        } catch (NoSuchElementException ns) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> update(@PathVariable int id, @RequestBody Cliente pcliente) {

        try {
            Cliente cliente = service.consultarPorId(id);

            cliente.setNome(pcliente.getNome());
            cliente.setTelefone(pcliente.getTelefone());
            cliente.setCpf(pcliente.getCpf());

            Usuario usuarioSuporte = usuarioService.obterPorEmail("support@gmail.com");
            cliente.setUsuario(usuarioSuporte);

            service.salvar(cliente);

            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

        } catch (NoSuchElementException ns) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Usuario usuarioSuporte = usuarioService.obterPorEmail("support@gmail.com");
        cliente.setUsuario(usuarioSuporte);

        service.salvar(cliente);

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") int id) {

        service.excluir(id);
        return new ResponseEntity(HttpStatus.OK);


    }
}




