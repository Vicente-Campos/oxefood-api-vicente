package br.com.ifpe.oxefood.modelo.categoria;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    @Transactional
    public Categoria save(Categoria categoria) {

        categoria.setHabilitado(Boolean.TRUE);
        categoria.setVersao(1L);
        categoria.setDataCriacao(LocalDate.now());
        return repository.save(categoria);
    }

    public List<Categoria> listarTodos() {

        return repository.findAll();
    }

    public Categoria obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Categoria categoriaAlterado) {

        Categoria categoria = repository.findById(id).get();
        categoria.setDescricao(categoriaAlterado.getDescricao());

        categoria.setVersao(categoria.getVersao() + 1);
        repository.save(categoria);
    }

    @Transactional
    public void delete(Long id) {

        Categoria categoria = repository.findById(id).get();
        categoria.setHabilitado(Boolean.FALSE);
        categoria.setVersao(categoria.getVersao() + 1);

        repository.save(categoria);
    }

}
