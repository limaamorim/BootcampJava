package br.com.exercicio.model;

import java.time.LocalDate;

public class Jogador {

    public String nome;
    public String posicao; // DEFESA, MEIO_CAMPO, ATAQUE
    public LocalDate dataNascimento;
    public String nacionalidade;
    public double altura;
    public double peso;

    public Jogador(String nome, String posicao, LocalDate dataNascimento,
                   String nacionalidade, double altura, double peso) {
        this.nome = nome;
        this.posicao = posicao;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
}
