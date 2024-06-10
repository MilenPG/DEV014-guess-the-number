import java.util.Random; //lo usaremos como atributo dentro de una clase para definir nro ganador
import java.util.ArrayList; //luego dentro de la clase donde se usará, se debe especificar tipo de dato entre "<>", si es combinación, se dejan vacíos.
import java.util.Scanner;

public class GuessTheNumberGame {
    // buena práctica: generar atributos y sus datos con acceso "private" o "protected"
    private Random random; //atributo 1: util.Random = hacer uso de librería de Java para crear nro. aleatorio - random tiene su propio tipo de dato "Random"
    private int targetNumber;

    public GuessTheNumberGame() {
        this.random = new Random(); //estudiar uso del this - solo para atributos y métodos que estén dentro de una misma clase creada
        this.targetNumber = random.nextInt(1, 101);
    }

    public int getTargetNumber() {
        return this.targetNumber;
    }
    public boolean checkGuess(Player player) {
        //Elaborar lógica con if para evaluar cada respuesta
        //if guess === targetNumber return true
        return true;
    }

    public static void main(String [] args) {
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame(); // Aquí estamos 'instanciando' la clase, es decir invocándola para poder usarla a ella y sus atributos dentro de este encapsulamiento
        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
        System.out.println("☆  G U E S S   T H E   N U M B E R   ☆   T h e   G a m e  ☆");
        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
        System.out.println("To get started, please enter your name here: "); // Agregar scanner para que la persona escriba su nombre y poder usarlo.
        System.out.println("Welcome + Player.getName() + !");
        System.out.println("Instructions: So as the name says, you have to guess and type in a number between 1 and 100 until either you or the computer guesses the secret winning number.");
        System.out.println("You and the computer will take turns, one by one, to print out your respective answers, until one of you wins :D !");
        System.out.println("testing winner number: "+guessTheNumberGame.getTargetNumber());
        ArrayList<Integer> humanGuesses = new ArrayList<Integer>();
        ArrayList<Integer> computerGuesses = new ArrayList<Integer>();
        HumanPlayer humanPlayer = new HumanPlayer("Pirita", humanGuesses);
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer", computerGuesses);
        System.out.println(humanPlayer.makeGuess());
        System.out.println(guessTheNumberGame.checkGuess(humanPlayer));

    }

    /*
        1. checkGuesses, dentro de un while, lo debo usar 2 veces: 1 para evaluar intento humanGuess y otra para computerGuess
        2. Dentro del mismo while, debo implementar condicional para ganador y fin del juego.
         (para pruebas, podría acortar el rango de adivinanza)
    */

}
