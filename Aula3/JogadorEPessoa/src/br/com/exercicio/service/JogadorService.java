package br.com.exercicio.service;

import br.com.exercicio.model.Jogador;

import java.time.LocalDate;
import java.time.Period;

public class JogadorService {

    public int calcularIdade(Jogador jogador) {
        return Period.between(
                jogador.getDataNascimento(),
                LocalDate.now()
        ).getYears();
    }

    private int idadeAposentadoria(Jogador jogador) {
        return switch (jogador.getPosicao().toUpperCase()) {
            case "DEFESA" -> 40;
            case "MEIO_CAMPO" -> 38;
            case "ATAQUE" -> 35;
            default -> -1;
        };
    }

    public int anosParaAposentar(Jogador jogador) {
        int idadeAtual = calcularIdade(jogador);
        int idadeLimite = idadeAposentadoria(jogador);

        if (idadeLimite == -1) {
            return -1;
        }

        return idadeLimite - idadeAtual;
    }

    public void imprimirDados(Jogador jogador) {
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Posição: " + jogador.getPosicao());
        System.out.println("Idade: " + calcularIdade(jogador));
        System.out.println("Nacionalidade: " + jogador.getNacionalidade());
        System.out.println("Altura: " + jogador.getAltura() + " m");
        System.out.println("Peso: " + jogador.getPeso() + " kg");

        int anos = anosParaAposentar(jogador);

        if (anos > 0) {
            System.out.println("Anos para aposentadoria: " + anos);
        } else if (anos == 0) {
            System.out.println("Aposenta esse ano");
        } else if (anos < 0) {
            System.out.println("Aposentado há " + Math.abs(anos) + " anos");
        } else {
            System.out.println("Posição inválida");
        }
    }
}
