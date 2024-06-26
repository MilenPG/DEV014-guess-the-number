import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessTheNumberGame {
    protected Random random;
    protected int targetNumber;

    public GuessTheNumberGame() {
        this.random = new Random(); //estudiar uso del this - solo para atributos y métodos que estén dentro de una misma clase creada
        this.targetNumber = random.nextInt(0, 10);
    }
    public int getTargetNumber() {
        return this.targetNumber;
    }
    public boolean checkGuess(Player player, int targetNumber) {
        boolean endOfTheGame;
      if (player.lastGuess == targetNumber) {
          endOfTheGame = true;
      }
      else {
        endOfTheGame = false;
     }
      return endOfTheGame;
    }
    public void clueMessage(Player player) {
        if (player.lastGuess > this.targetNumber) {
            System.out.println("Too high!\n");
        } else if (player.lastGuess < this.targetNumber) {
            System.out.println("Too low!\n");
        }
    }

    public static void main(String [] args) {
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame(); // Aquí estamos 'instanciando' la clase, es decir, creandola para poder usarla a ella y sus atributos dentro de este encapsulamiento
        System.out.println("☆----------------------------------------------------------☆");
        System.out.println("|  G U E S S   T H E   N U M B E R   ☆   T h e   G a m e   |");
        System.out.println("☆--------------------------------------------------------- ☆");
        System.out.println("\nTo get started, please enter your name here: ");
        Scanner nameScanner = new Scanner(System.in);
        final String name = nameScanner.nextLine();
        System.out.println(name+", welcome to the Guess the Number game! \n");
        System.out.println("Instructions: So as the name says, you have to guess and type in a number between 1 and 100 until either you or the computer guesses the secret winning number.");
        System.out.println("You and the computer will take turns, one by one, to print out your respective answers, until one of you wins :D !");

        System.out.println("\n[Testing winner number: "+guessTheNumberGame.getTargetNumber()+"]\n");

        ArrayList<Integer> humanGuesses = new ArrayList<Integer>();
        ArrayList<Integer> computerGuesses = new ArrayList<Integer>();
        HumanPlayer humanPlayer = new HumanPlayer(name, humanGuesses);
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer", computerGuesses);


        int counter = 0;
         do {
            counter++;
            System.out.println("\n---- Round " + counter + " ----");
            humanPlayer.makeGuess();
            if (!guessTheNumberGame.checkGuess(humanPlayer, guessTheNumberGame.getTargetNumber())) {
               guessTheNumberGame.clueMessage(humanPlayer);
                computerPlayer.makeGuess();
                guessTheNumberGame.clueMessage(computerPlayer);
                if(guessTheNumberGame.checkGuess(computerPlayer, guessTheNumberGame.getTargetNumber())==true){
                    System.out.println("\n***COMPUTER WINS * END OF THE GAME***\n Computer's attempts history: "+computerGuesses);

                }
            } else {
                System.out.println("☆ CONGRATULATIONS! ☆ You win! (ﾉ◕3◕)ﾉ ♡ *:･ﾟ✧ ▽ ﾟ. *･｡ ﾟ ☆");
                System.out.println("\n***HUMAN WINS * END OF THE GAME***\n"+name+"'s attempts history: "+humanGuesses);
            }
         }
        while (
                guessTheNumberGame.checkGuess(humanPlayer, guessTheNumberGame.getTargetNumber())==false &&
                guessTheNumberGame.checkGuess(computerPlayer, guessTheNumberGame.getTargetNumber())==false
         );
    }
}
