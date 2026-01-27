package com.nando.Cadastro.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Positive(message = "Preco deve ser maior que zero")
    private Double preco;

    private Integer quantidade;

    public ProdutoRequestDTO(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
