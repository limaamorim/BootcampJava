package com.nando.Cadastro.dto;

public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private Boolean ativo;

    public ProdutoResponseDTO (){}

    public ProdutoResponseDTO(Long id, String nome, Double preco, Integer quantidade, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
