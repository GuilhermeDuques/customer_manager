package br.edu.infnet.springmvc.model.service;

import br.edu.infnet.springmvc.model.negocio.Cliente;
import br.edu.infnet.springmvc.model.negocio.Usuario;
import br.edu.infnet.springmvc.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public void excluir(Integer id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> obterLista() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public List<Cliente> obterLista(Usuario usuario) {
        return (List<Cliente>) clienteRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }


    public Cliente consultarPorId(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> consultar() {
        return (List<Cliente>) clienteRepository.findAll();
    }
}
