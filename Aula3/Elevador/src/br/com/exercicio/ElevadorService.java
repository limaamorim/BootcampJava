package br.com.exercicio;

import br.com.exercicio.Elevador;

public class ElevadorService {

    public void entra(Elevador elevador) {
        if (elevador.getPessoasPresentes() < elevador.getCapacidade()) {
            elevador.setPessoasPresentes(
                    elevador.getPessoasPresentes() + 1
            );
            System.out.println("Uma pessoa entrou no elevador");

        } else {
            System.out.println("Elevador cheio!");
        }
    }

    public void sai(Elevador elevador) {
        if (elevador.getPessoasPresentes() > 0) {
            elevador.setPessoasPresentes(
                    elevador.getPessoasPresentes() - 1
            );
            System.out.println("Uma pessoa saiu no elevador");
        } else {
            System.out.println("Elevador vazio!");
        }
    }

    public void sobe(Elevador elevador) {
        if (elevador.getAndarAtual() < elevador.getTotalDeAndares()) {
            elevador.setAndarAtual(
                    elevador.getAndarAtual() + 1
            );
            System.out.println("O elevador subiu 1° andar");
        } else {
            System.out.println("Já está no último andar!");
        }
    }

    public void desce(Elevador elevador) {
        if (elevador.getAndarAtual() > 0) {
            elevador.setAndarAtual(
                    elevador.getAndarAtual() - 1
            );
            System.out.println("O elevador desceu 1° andar");
        } else {
            System.out.println("Já está no térreo!");
        }
    }

    public void status(Elevador elevador) {
        System.out.println("Andar atual: " + elevador.getAndarAtual());
        System.out.println("Pessoas no elevador: " + elevador.getPessoasPresentes());
        System.out.println("Capacidade máxima: " + elevador.getCapacidade());
    }
}
