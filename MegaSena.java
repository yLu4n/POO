package Megasena;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
public class MegaSena {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao jogo da Mega Sena!");
        System.out.println("Escolha 6 números entre 1 e 60.");
        
        TreeSet<Integer> playerNumbers = getPlayerNumbers(scanner);
        TreeSet<Integer> winningNumbers = generateWinningNumbers();
        
        
        
        System.out.println("Números escolhidos: " + playerNumbers);
        System.out.println("Números sorteados: " + winningNumbers);
        
        int matches = countMatches(playerNumbers, winningNumbers);
        
        if (matches == 6) {
            System.out.println("Parabéns! Você ganhou o prêmio principal!");
        } else if (matches >= 4) {
            System.out.println("Parabéns! Você acertou " + matches + " números e ganhou um prêmio!");
        } else {
            System.out.println("Não foi dessa vez. Tente novamente!");
        }
    }

    public static TreeSet<Integer> getPlayerNumbers(Scanner scanner) {
        TreeSet<Integer> playerNumbers = new TreeSet<>();
        
        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            int num = scanner.nextInt();
            
            while (num < 1 || num > 60) {
                System.out.println("Número inválido. Escolha novamente.");
                System.out.print("Digite o " + (i + 1) + "º número: ");
                num = scanner.nextInt();
            }
            
            playerNumbers.add(num);
        }
        
        return playerNumbers;
    }

    public static TreeSet<Integer> generateWinningNumbers() {
        TreeSet<Integer> winningNumbers = new TreeSet<>();
        Random random = new Random();
        
        while (winningNumbers.size() < 6) {
            int num = random.nextInt(60) + 1;
            winningNumbers.add(num);
        }
        
        return winningNumbers;
    }

    public static int countMatches(TreeSet<Integer> playerNumbers, TreeSet<Integer> winningNumbers) {
        int count = 0;
        
        for (int num : playerNumbers) {
            if (winningNumbers.contains(num)) {
                count++;
            }
        }
        
        return count;
    }
}