package br.com.exercicio.service;

import br.com.exercicio.model.Pessoa;

import java.time.LocalDate;
import java.time.Period;

public class PessoaService {

    public int calcularIdade(Pessoa pessoa) {
        return Period.between(
                pessoa.getDataNascimento(),
                LocalDate.now()
        ).getYears();
    }

    public String formatarDados(Pessoa pessoa) {
        return "Nome: " + pessoa.getNome()
                + "\nAltura: " + pessoa.getAltura()
                + "\nData de nascimento: " + pessoa.getDataNascimento()
                + "\nIdade: " + calcularIdade(pessoa);
    }

    public void imprimirDados(Pessoa pessoa) {
        System.out.println(formatarDados(pessoa));
    }
}
