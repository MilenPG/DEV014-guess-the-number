import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, ArrayList<Integer> guesses) {
        super(name, guesses);
    }

    public int makeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getName() + ", type your guess here: ");
        int humanGuess = scanner.nextInt();
        getGuesses().add(humanGuess); //agrega cada jugada al historial
        return humanGuess;
    }

}