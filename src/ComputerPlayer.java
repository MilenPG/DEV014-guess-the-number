import java.util.Random;
import java.util.ArrayList;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(String name, ArrayList<Integer> guesses) {
        super(name, guesses); //solo instanciamos los atributos ya construidos en la superclase.
    }

    public int makeGuess() {
        this.random = new Random();
        System.out.println("✧ ✧ ✧\n\nCOMPUTER guess: ");
        int computerGuess = random.nextInt(1,100);
        System.out.println(computerGuess);
        this.lastGuess = computerGuess;
        getGuesses().add(computerGuess);
        return computerGuess;
    }
}
