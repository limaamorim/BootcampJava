import br.com.exercicio.model.Pessoa;
import br.com.exercicio.model.Jogador;

import br.com.exercicio.service.PessoaService;
import br.com.exercicio.service.JogadorService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        JogadorService jogadorService = new JogadorService();


        int opcao;

        do {
            System.out.println("""
                    ===== MENU PRINCIPAL =====
                    1 - Criar Pessoa
                    2 - Cadastrar Jogador
                    3 - Sair
                   
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                // ================== PESSOA ==================
                case 1 -> {
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Ano de nascimento: ");
                    int ano = scanner.nextInt();

                    System.out.print("Mês de nascimento: ");
                    int mes = scanner.nextInt();

                    System.out.print("Dia de nascimento: ");
                    int dia = scanner.nextInt();

                    System.out.print("Altura (ex: 1.75): ");
                    double altura = scanner.nextDouble();

                    try {
                        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
                        Pessoa pessoa = new Pessoa(nome, dataNascimento, altura);

                        System.out.println("\n--- DADOS DA PESSOA ---");
                        pessoaService.imprimirDados(pessoa);
                        System.out.println("----------------------\n");

                    } catch (Exception e) {
                        System.out.println("Data inválida!");
                    }
                }

                // ================== JOGADOR ==================
                case 2 -> {
                    System.out.print("Nome do jogador: ");
                    String nome = scanner.nextLine();

                    System.out.print("Posição (DEFESA / MEIO_CAMPO / ATAQUE): ");
                    String posicao = scanner.nextLine();

                    System.out.print("Ano de nascimento: ");
                    int ano = scanner.nextInt();

                    System.out.print("Mês de nascimento: ");
                    int mes = scanner.nextInt();

                    System.out.print("Dia de nascimento: ");
                    int dia = scanner.nextInt();

                    scanner.nextLine();
                    System.out.print("Nacionalidade: ");
                    String nacionalidade = scanner.nextLine();

                    System.out.print("Altura (ex: 1.80): ");
                    double altura = scanner.nextDouble();

                    System.out.print("Peso (kg): ");
                    double peso = scanner.nextDouble();

                    try {
                        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);

                        Jogador jogador = new Jogador(
                                nome, posicao, dataNascimento,
                                nacionalidade, altura, peso
                        );

                        System.out.println("\n--- DADOS DO JOGADOR ---");
                        jogadorService.imprimirDados(jogador);
                        System.out.println("------------------------\n");

                    } catch (Exception e) {
                        System.out.println("Data inválida!");
                    }
                }
                case 3 -> {
                    System.out.println("Encerrando o programa");
                }
                }

        } while (opcao != 3);

        scanner.close();
    }
}
