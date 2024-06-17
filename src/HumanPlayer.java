import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, ArrayList<Integer> guesses) {
        super(name, guesses);
    }

    public int makeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getName().toUpperCase() + ", enter your guess: ");
        int humanGuess = scanner.nextInt();
        this.lastGuess = humanGuess;
        getGuesses().add(humanGuess); //agrega cada jugada al historial
        return humanGuess;
    }

}