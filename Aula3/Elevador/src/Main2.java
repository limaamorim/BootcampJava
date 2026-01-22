import br.com.exercicio.Elevador;
import br.com.exercicio.ElevadorService;

import java.util.Scanner;
//
public class Main2 {
    public static void main(String[] args) {
        //it
        Scanner scanner = new Scanner(System.in);

        ElevadorService elevadorService = new ElevadorService();

        System.out.println("=== CONFIGURAÇÃO DO ELEVADOR ===");
        System.out.print("Capacidade do elevador: ");
        int capacidade = scanner.nextInt();

        System.out.print("Total de andares: ");
        int totalAndares = scanner.nextInt();

        Elevador elevador = new Elevador(capacidade, totalAndares);

        int opcao;
        do {
            System.out.println("""
                    ---- MENU ELEVADOR ----
                    1 - Entrar pessoa
                    2 - Sair pessoa
                    3 - Subir
                    4 - Descer
                    5 - Status
                    6 - Sair
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> elevadorService.entra(elevador);
                case 2 -> elevadorService.sai(elevador);
                case 3 -> elevadorService.sobe(elevador);
                case 4 -> elevadorService.desce(elevador);
                case 5 -> elevadorService.status(elevador);
                case 6 -> System.out.println("Encerrando menu do elevador...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 6);

        scanner.close();
    }
}
