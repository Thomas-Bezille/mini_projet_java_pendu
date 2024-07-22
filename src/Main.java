import com.dyma.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final var scanner = new Scanner(System.in);
        final var random = new Random();
        final var words = "fleur voiture océan montagne livre soleil arbre chat téléphone maison".split(" ");
        final var wordToGuess = words[random.nextInt(words.length)];
        final var game = new GuessGame(wordToGuess, 10);

        System.out.println("Le jeu débute !");

        while (true) {
            System.out.println(game);
            System.out.println("Entrez une lettre :");
            final var letter = scanner.nextLine().charAt(0);

            game.guessLetter(letter);

            if (game.isLost()) {
                System.out.println(game);
                System.out.println("Perdu !");
                break;
            }

            if (game.isWin()) {
                System.out.println(game);
                System.out.println("Gagné !");
                break;
            }
        }
    }
}