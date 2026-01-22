package br.com.exercicio.model;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private double altura; // em metros

    public Pessoa(String nome, LocalDate dataNascimento, double altura) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura;
    }
}
