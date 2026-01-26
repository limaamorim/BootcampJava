package com.nando.Cadastro.service;

import org.springframework.stereotype.Service;

import com.nando.Cadastro.model.Produto;
import com.nando.Cadastro.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> listarTodos(){
            return repository.findAll();
    }

    public Produto buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
