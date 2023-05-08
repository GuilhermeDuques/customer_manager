package br.edu.infnet.springmvc.model.service;

import br.edu.infnet.springmvc.model.negocio.Usuario;
import br.edu.infnet.springmvc.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticacao(String email, String senha) {
        return usuarioRepository.autenticacao(email, senha);
    }

    public void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> obterLista() {
        return (List<Usuario>) usuarioRepository.obterLista(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public Usuario obterPorEmail(String email) {
        return usuarioRepository.obterPorEmail(email);
    }
}

