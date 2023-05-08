package br.edu.infnet.springmvc.model.repository;

import br.edu.infnet.springmvc.model.negocio.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    @Query("from Cliente c where c.usuario.id=:id")
    List<Cliente> obterLista(Integer id, Sort by);
}
