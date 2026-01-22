import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if (idade < 18) {
            System.out.println("Olá, " + nome + ".");
            System.out.println("Você é menor de idade e não pode jogar.");
            return; // encerra o programa
        }

        System.out.println("\nBem-vindo, " + nome + "! Vamos jogar 🎮");

        int numeroSecreto = random.nextInt(10) + 1;
        int tentativas = 3;

        while (tentativas > 0) {
            System.out.print("Digite um número de 1 a 10: ");
            int palpite = scanner.nextInt();

            // switch para a dica
            switch (Integer.compare(palpite, numeroSecreto)) {
                case 0 -> {
                    System.out.println("🎉 Parabéns! Você acertou!");
                    scanner.close();
                    return;
                }
                case -1 -> System.out.println("Dica: o número é MAIOR.");
                case 1 -> System.out.println("Dica: o número é MENOR.");
            }

            tentativas--;
            System.out.println("Tentativas restantes: " + tentativas + "\n");
        }

        System.out.println("Fim de jogo!");
        System.out.println("O número correto era: " + numeroSecreto);

        scanner.close();
    }
}
