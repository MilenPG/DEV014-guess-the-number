import java.util.Random;
import java.util.ArrayList;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(String name, ArrayList<Integer> guesses) {
        super(name, guesses); //solo instanciamos los atributos ya construidos en la superclase.
    }

    public int makeGuess() {
        this.random = new Random();
        System.out.println("Computer guess: ");
        int computerGuess = random.nextInt(0, 101);
        System.out.println(computerGuess);
        getGuesses().add(computerGuess);
        return computerGuess;
    }
}
