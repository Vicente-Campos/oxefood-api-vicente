package br.com.ifpe.oxefood.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Exemplo de uma busca exata
   @Query(value = "SELECT c FROM Cliente c WHERE c.cpf like %:cpf%")
   List<Cliente> consultarPorCpf(String cpf);

   //Exemplo de uma busca aproximada com ordenação:
   // @Query(value = "SELECT p FROM Produto p WHERE p.titulo like %:titulo% ORDER BY p.titulo")
   // List<Produto> consultarPorTitulo(String titulo);
   List<Cliente> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);

   //Exemplo de uma busca exata como um atributo de relacionamento
   //@Query(value = "SELECT p FROM Produto p WHERE p.categoria.id = :idCategoria")
   //List<Produto> consultarPorCategoria(Long idCategoria);

   //Exemplo de uma busca com mais de um atributo
   @Query(value = "SELECT c FROM Cliente c WHERE c.nome like %:nome% AND c.cpf = :cpf")
   List<Cliente> consultarPorNomeECpf(String nome, String cpf);

  
}
