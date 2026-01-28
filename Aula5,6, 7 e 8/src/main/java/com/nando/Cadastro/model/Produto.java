package com.nando.Cadastro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity // Transforma a classe em tabela
@Table(name = "produtos") // Da  nome para a tabela
public class Produto {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id automático
    private Long id;

    private String nome;
    private Double preco;
    private Integer quantidade;
    private Boolean ativo;

    public Produto() {}

    public Produto(String nome, Double preco, Integer quantidade, Boolean ativo) {
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
