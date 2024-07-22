import com.dyma.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final var random = new Random();
        final var words = "fleur voiture océan montagne livre soleil arbre chat téléphone maison".split(" ");
        var wordToGuess = words[random.nextInt(words.length)];
        var game = new GuessGame(wordToGuess, 10);

        System.out.println("Le jeu débute !");

        while (true) {
            System.out.println(game);
            final var letter = scanLetter("Entrez une lettre :");

            game.guessLetter(letter);

            if (game.isLost()) {
                System.out.println(game);
                System.out.println("Perdu !");
            }

            if (game.isWin()) {
                System.out.println(game);
                System.out.println("Gagné !");
            }

            if (game.isWin() || game.isLost()) {
                var replayAnswer = scanLetter("Voulez-vous rejouer ? (O/N)");
                if (replayAnswer == 'o' || replayAnswer == 'O') {
                    wordToGuess = words[random.nextInt(words.length)];
                    game = new GuessGame(wordToGuess, 10);
                } else {
                    break;
                }
            }
        }
    }

    private static char scanLetter(String question) {
        final var scanner = new Scanner(System.in);
        Character letter = null;
        do {
            System.out.println(question);
            var input = scanner.nextLine();

            if (input.length() == 1) {
                letter = input.charAt(0);
            }

        } while (letter == null);

        return letter;
    }
}