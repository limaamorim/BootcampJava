package com.nando.Cadastro.service;

import org.springframework.stereotype.Service;

import com.nando.Cadastro.dto.ProdutoRequestDTO;
import com.nando.Cadastro.dto.ProdutoResponseDTO;
import com.nando.Cadastro.model.Produto;
import com.nando.Cadastro.repository.ProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    // injecao do construtor
    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    //Create
    @Override
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());
        produto.setAtivo(true);

        Produto salvo = repository.save(produto);

        return toResponseDTO(salvo);
    }

    // Listar todos
    @Override
    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Lista por id
    @Override
    public ProdutoResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    // Atualizar
    @Override
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {

        Produto produto = repository.findById(id).orElse(null);
        if (produto == null) return null;

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        Produto atualizado = repository.save(produto);

        return toResponseDTO(atualizado);
    }

    // Deletar
    @Override
    public boolean deletar(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    // Convertendo o DTO pra entidade que vai ser devolvida na api
    private ProdutoResponseDTO toResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade(),
                produto.getAtivo()
        );
    }
}
