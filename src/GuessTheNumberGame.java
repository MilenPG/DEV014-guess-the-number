import java.util.Random; //lo usaremos como atributo dentro de una clase para definir nro ganador
import java.util.ArrayList; //luego dentro de la clase donde se usará, se debe especificar tipo de dato entre "<>", si es combinación, se dejan vacíos.
import java.util.Scanner;

public class GuessTheNumberGame {
    // buena práctica: generar atributos y sus datos con acceso "private" o "protected"
    private Random random; //atributo 1: util.Random = hacer uso de librería de Java para crear nro. aleatorio - random tiene su propio tipo de dato "Random"
    private int targetNumber;

    public GuessTheNumberGame() {
        this.random = new Random(); //estudiar uso del this - solo para atributos y métodos que estén dentro de una misma clase creada
        this.targetNumber = random.nextInt(0, 100);
    }

    public int getTargetNumber() {
        return this.targetNumber;
    }
    public boolean checkGuess(Player player) {
        boolean endOfTheGame;
      if (player.lastGuess == this.targetNumber) {
          endOfTheGame = true;
      }
      else {
//        if (player.lastGuess > this.targetNumber) {
//            System.out.println("Too high!");
//        } else if (player.lastGuess < this.targetNumber) {
//            System.out.println("Too low!");
//        }
        endOfTheGame = false;
     }
      return endOfTheGame;
    }
            //Elaborar lógica con if para evaluar cada respuesta
            //if guess === targetNumber return true
        /*
        1. checkGuesses, dentro de un while, lo debo usar 2 veces: 1 para evaluar intento humanGuess y otra para computerGuess
        2. Dentro del mismo while, debo implementar condicional para ganador y fin del juego.
         (para pruebas, podría acortar el rango de adivinanza)
    */

    /*
        1. HumanPlayer hace su intento
        2. Evaluar intento HP
            2.1. Si intento = TN ---> HP gana.
            2.2. Si intento != TN ---> Comunicar "too low" o "too high" en caso respectivo. Continúa el juego.
        3. CP hace su intento.
        4. Evaluar intento CP
            4.1. Si intento = TN ---> CP gana.
            4.2. Si intento != TN ---> Comunicar "too low" o "too high" en caso respectivo. Continúa el juego.
        5. Evaluar si HP || CP gana ---> Terminar ciclo. Fin del juego.
        6. Si no ocurre lo anterior, volver a paso 1.
    * El ciclo ha de ejecutarse hasta que exista un ganador. While es el tipo de ciclo que nos permite implementar una condicional a la sucesión del ciclo (a diferencia de for q precisa un límite establecido de repeticiones, por eso no lo usamos)
    */

    public static void main(String [] args) {
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame(); // Aquí estamos 'instanciando' la clase, es decir creandola para poder usarla a ella y sus atributos dentro de este encapsulamiento
        System.out.println("☆----------------------------------------------------------☆");
        System.out.println("|  G U E S S   T H E   N U M B E R   ☆   T h e   G a m e   |");
        System.out.println("☆--------------------------------------------------------- ☆");
        System.out.println("\nTo get started, please enter your name here: "); // Agregar scanner para que la persona escriba su nombre y poder usarlo.
        Scanner nameScanner = new Scanner(System.in);
        final String name = nameScanner.nextLine();
        System.out.println(name+", welcome to the Guess the Number game! \n");
        System.out.println("Instructions: So as the name says, you have to guess and type in a number between 1 and 100 until either you or the computer guesses the secret winning number.");
        System.out.println("You and the computer will take turns, one by one, to print out your respective answers, until one of you wins :D !");

        System.out.println("\n[Testing winner number: "+guessTheNumberGame.getTargetNumber()+"]\n");

        ArrayList<Integer> humanGuesses = new ArrayList<Integer>(); //declaramos la variable
        ArrayList<Integer> computerGuesses = new ArrayList<Integer>();
        HumanPlayer humanPlayer = new HumanPlayer(name, humanGuesses);
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer", computerGuesses);


        int counter = 0;
         do {
            counter++;
            System.out.println("\n---- Round " + counter + " ----");
            humanPlayer.makeGuess();
            //guessTheNumberGame.checkGuess(humanPlayer);
            if (!guessTheNumberGame.checkGuess(humanPlayer)) {
                if (humanPlayer.lastGuess > guessTheNumberGame.targetNumber) {
                    System.out.println("Too high!\n");
                } else if (humanPlayer.lastGuess < guessTheNumberGame.targetNumber) {
                    System.out.println("Too low!\n");
                }
                computerPlayer.makeGuess();
                if (computerPlayer.lastGuess > guessTheNumberGame.targetNumber) {
                    System.out.println("Too high!");
                } else if (computerPlayer.lastGuess < guessTheNumberGame.targetNumber) {
                    System.out.println("Too low!");
                }
                if(guessTheNumberGame.checkGuess(computerPlayer)==true){
                    System.out.println("\n***COMPUTER WINS * END OF THE GAME***\n Computer's attempts history: "+computerGuesses);

                }
            } else {
                System.out.println("CONGRATULATIONS! You win! (ﾉ◕3◕)ﾉ ♡ *:･ﾟ✧▽ ☆ﾟ. *･｡ﾟ");
                System.out.println("\n***HUMAN WINS * END OF THE GAME***\n"+name+"'s attempts history: "+humanGuesses);
            }
         }
        while (
                guessTheNumberGame.checkGuess(humanPlayer)==false &&
                guessTheNumberGame.checkGuess(computerPlayer)==false
         );
    }
}
